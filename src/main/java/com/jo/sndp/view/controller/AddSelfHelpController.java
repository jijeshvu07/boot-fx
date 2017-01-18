package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.dao.modal.FamilyMember;
import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.entity.SakhaDetails;
import com.jo.sndp.entity.SelfHelpGroup;
import com.jo.sndp.entity.SelfHelpGroupDetails;
import com.jo.sndp.entity.Union;
import com.jo.sndp.service.MemberDetailsService;
import com.jo.sndp.service.MemberService;
import com.jo.sndp.service.SakhaDetailsService;
import com.jo.sndp.service.SelfHelpGroupService;
import com.jo.sndp.service.UnionService;
import com.jo.sndp.view.util.Screens;
import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

@Component
public class AddSelfHelpController implements BootInitializable {
	private ApplicationContext applicationContext;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDetailsService memberDetailsService;
	@Autowired
	private UnionService unionService;
	@Autowired
	private SakhaDetailsService sakhaDetailsService;
	@Autowired
	private SelfHelpGroupService selfHelpGroupService;
	@Autowired
	private HomeController homeController;
	@FXML
	private Label errInSHGroup;
	@FXML
	private ComboBox<Union> cmboUnion;
	@FXML
	private ComboBox<SakhaDetails> cmboSakha;
	@FXML
	private TextField txtSHGName, txtPlaceName, txtConveener, txtJointConveener, txtMemberCode;
	@FXML
	private DatePicker txtPeriodFrom, txtPeriodTo;
	@FXML
	private TableView<FamilyMember> tblMembers;
	@FXML
	private TableColumn<FamilyMember, String> columnName;
	@FXML
	private TableColumn<FamilyMember, String> columnCode;
	@FXML
	private TableColumn columnAction;

	private List<FamilyMember> members;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clearAllFields();
		loadUnion();
	}

	private void loadUnion() {
		cmboUnion.getItems().clear();
		List<Union> unions = unionService.findAllUnion();
		if (unions != null && !unions.isEmpty()) {
			class UnionListCell extends ListCell<Union> {
				protected void updateItem(Union Union, boolean empty) {
					super.updateItem(Union, empty);
					if (Union != null) {
						setText(Union.getUnionName());
					}
				}
			}
			cmboUnion.setButtonCell(new UnionListCell());
			cmboUnion.setCellFactory(new Callback<ListView<Union>, ListCell<Union>>() {
				public ListCell<Union> call(ListView<Union> p) {
					return new UnionListCell();
				}
			});
			cmboUnion.getItems().addAll(unions);
		}

	}

	@FXML
	public void selectUnion() {
		cmboSakha.getItems().clear();
		if (cmboUnion.getValue() != null) {
			Union union = cmboUnion.getValue();
			List<SakhaDetails> sakhaDetails = sakhaDetailsService.findAllSakhaDetailsByUnion(union.getId());
			if (sakhaDetails != null && !sakhaDetails.isEmpty()) {
				class SakhaListCell extends ListCell<SakhaDetails> {
					protected void updateItem(SakhaDetails details, boolean empty) {
						super.updateItem(details, empty);
						if (details != null) {
							setText(details.getSakhaName());
						}
					}
				}
				cmboSakha.setButtonCell(new SakhaListCell());
				cmboSakha.setCellFactory(new Callback<ListView<SakhaDetails>, ListCell<SakhaDetails>>() {
					public ListCell<SakhaDetails> call(ListView<SakhaDetails> arg0) {
						return new SakhaListCell();
					}
				});
				cmboSakha.getItems().addAll(sakhaDetails);
			}
		}
	}

	private void clearAllFields() {
		members = new ArrayList<FamilyMember>();
		errInSHGroup.setText("");
		cmboUnion.setValue(null);
		cmboSakha.setValue(null);
		txtSHGName.setText("");
		txtPlaceName.setText("");
		txtConveener.setText("");
		txtJointConveener.setText("");
		// txtPeriodFrom.setValue(LocalDate.now());
		txtMemberCode.setText("");
		tblMembers.getItems().clear();
	}

	@FXML
	public void selectPeriodFrom() {
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(txtPeriodTo.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};
		txtPeriodTo.setDayCellFactory(dayCellFactory);
		txtPeriodTo.setValue(txtPeriodFrom.getValue().plusDays(1));
	}

	@FXML
	public void onMemberEntered() {
		if (txtMemberCode.getText().isEmpty()) {
			homeController.showMsg(AlertType.ERROR, "Please enter member code");
		} else {
			Member member = memberService.findMemberByMemberCode(txtMemberCode.getText());
			boolean memberflag = true;
			if (member == null) {
				memberflag = false;

			}
			MemeberDetails details = memberDetailsService.findMemeberDetailsByMemberCode(txtMemberCode.getText());
			boolean memberDetailflag = true;
			if (details == null) {
				memberDetailflag = false;
			}
			if (memberflag || memberDetailflag) {
				FamilyMember familyMember = new FamilyMember();
				if (member != null) {
					familyMember.setName(member.getMemberName());
					familyMember.setCode(member.getMemeberCode());
				} else if (details != null) {
					familyMember.setName(details.getMemberName());
					familyMember.setCode(details.getMemberCode());
				}
				columnName.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("name"));
				columnCode.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("code"));

				columnAction.setCellValueFactory(
						new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {
							@Override
							public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
								return new SimpleBooleanProperty(p.getValue() != null);
							}
						});
				// Adding the Button to the cell
				columnAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {
					@Override
					public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
						return new ButtonCell();
					}
				});
				tblMembers.getItems().add(familyMember);
				members.add(familyMember);
			} else if (!memberflag || !memberDetailflag) {
				homeController.showMsg(AlertType.ERROR,
						"Member with code " + txtMemberCode.getText() + " not found !");
			}
		}
	}

	public String validateMemberCode(String code, String type) {
		Member member = memberService.findMemberByMemberCode(code);
		boolean memberflag = true;
		if (member == null) {
			memberflag = false;

		}
		MemeberDetails details = memberDetailsService.findMemeberDetailsByMemberCode(code);
		boolean memberDetailflag = true;
		if (details == null) {
			memberDetailflag = false;
		}
		if (memberflag || memberDetailflag) {
			return code;
		} else if (!memberflag || !memberDetailflag) {
			if (type.equalsIgnoreCase("conveener")) {
				homeController.showMsg(AlertType.ERROR, "Conveener with code " + code + " not found !");
			} else {
				homeController.showMsg(AlertType.ERROR, "Joing Conveener with code " + code + " not found !");
			}
			return null;
		}
		return null;

	}

	@FXML
	private void saveSHG() {
		errInSHGroup.setText("");
		if (cmboUnion.getValue() == null) {
			errInSHGroup.setText("Please select union");
		} else if (cmboSakha.getValue() == null) {
			errInSHGroup.setText("Please select sakha");
		} else if (txtSHGName.getText().isEmpty()) {
			errInSHGroup.setText("Please enter shg  name");
		} else if (txtPlaceName.getText().isEmpty()) {
			errInSHGroup.setText("Please enter place name");
		} else if (txtConveener.getText().isEmpty()) {
			errInSHGroup.setText("Please enter conveener member code");
		} else if (txtJointConveener.getText().isEmpty()) {
			errInSHGroup.setText("Please enter joint conveener member code");
		} else if (txtPeriodFrom.getValue() == null) {
			errInSHGroup.setText("Please select period from");
		} else if (txtPeriodTo.getValue() == null) {
			errInSHGroup.setText("Please select period to");
		} else if (tblMembers.getItems().isEmpty()) {
			errInSHGroup.setText("Please enter member details");
		} else {
			String conveenrValidation = validateMemberCode(txtConveener.getText(), "conveener");
			String jointconveenrValidation = validateMemberCode(txtJointConveener.getText(), "jointconveener");
			if (conveenrValidation != null && jointconveenrValidation != null) {
				try {
					SelfHelpGroup selfHelpGroup = new SelfHelpGroup();
					selfHelpGroup.setConveenerCode(conveenrValidation);
					selfHelpGroup.setJointConveenerCode(jointconveenrValidation);
					selfHelpGroup.setCreatedDate(new Date());
					selfHelpGroup.setDelete(false);
					selfHelpGroup.setPeriodFrom(Date
							.from(txtPeriodFrom.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
					selfHelpGroup.setPeriodto(Date
							.from(txtPeriodTo.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
					selfHelpGroup.setPlace(txtPlaceName.getText());
					selfHelpGroup.setSakhaDetails(cmboSakha.getValue());
					selfHelpGroup.setShgName(txtSHGName.getText());
					selfHelpGroup.setUnion(cmboUnion.getValue());
					List<SelfHelpGroupDetails> details = new ArrayList<SelfHelpGroupDetails>();
					if (members != null && !members.isEmpty()) {
						for (FamilyMember member : members) {
							SelfHelpGroupDetails modal = new SelfHelpGroupDetails();
							modal.setCreatedDate(new Date());
							modal.setMemberCode(member.getCode());
							modal.setSelfHelpGroup(selfHelpGroup);
							details.add(modal);
						}
					}
					selfHelpGroup.setDetails(details);
					selfHelpGroupService.saveSelfHelpGroup(selfHelpGroup);
					clearAllFields();
					homeController.showMsg(AlertType.INFORMATION, "SHG saved successfully");
				} catch (Exception e) {
					homeController.showMsg(AlertType.ERROR, "Error while saving SHG !");
				}

			}

		}

	}

	// Define the button cell
	private class ButtonCell extends TableCell<Record, Boolean> {
		final Button cellButton = new Button("Delete");

		ButtonCell() {
			// Action when the button is pressed
			cellButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					// get Selected Item
					FamilyMember member = (FamilyMember) ButtonCell.this.getTableView().getItems()
							.get(ButtonCell.this.getIndex());
					tblMembers.getItems().remove(member);
					members.remove(member);
					// remove selected item from the table list
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {
				setGraphic(cellButton);
			} else {
				setGraphic(null);
			}
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void initConstruct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stage(Stage primaryStage) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node initView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(Screens.ADD_SELF_HELP));
			loader.setController(this);
			return loader.load();
		} catch (IOException e) {
			System.err.println("can't load scene");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void initValidator() {
		// TODO Auto-generated method stub

	}

}
