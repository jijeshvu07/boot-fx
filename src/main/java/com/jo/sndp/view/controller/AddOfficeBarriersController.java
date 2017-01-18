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
import com.jo.sndp.entity.Designation;
import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.entity.OfficeBarrier;
import com.jo.sndp.entity.OfficeBarrierDetails;
import com.jo.sndp.entity.SakhaDetails;
import com.jo.sndp.entity.Union;
import com.jo.sndp.service.DesignationService;
import com.jo.sndp.service.MemberDetailsService;
import com.jo.sndp.service.MemberService;
import com.jo.sndp.service.OfficeBarrierService;
import com.jo.sndp.service.SakhaDetailsService;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
@Component
public class AddOfficeBarriersController implements BootInitializable {
	private ApplicationContext applicationContext;
	@Autowired
	private UnionService unionService;
	@Autowired
	private SakhaDetailsService sakhaDetailsService;
	@Autowired
	private DesignationService designationService;
	@Autowired
	private OfficeBarrierService officeBarrierService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDetailsService memberDetailsService;
	@Autowired
	private HomeController homeController;
	@FXML
	private DatePicker txtdateFrom, txtdateTo;
	@FXML
	private TextField txtGroupName, txtItemName, txtMembercode;
	@FXML
	private Label lblUnionName, errInOfficeBarrier;
	@FXML
	private ComboBox<SakhaDetails> cmboSakha;
	@FXML
	private ComboBox<Designation> cmboDesignation;
	@FXML
	private GridPane gridUnion, gridSakha;
	@FXML
	private RadioButton radioUnion, radioSakha;
	@FXML
	private TableView<FamilyMember> tblMember;
	@FXML
	private TableColumn<FamilyMember, String> columnMemberCode;
	@FXML
	private TableColumn<FamilyMember, String> columnDesignation;
	@FXML
	private TableColumn<FamilyMember, String> columnName;
	@FXML
	private TableColumn columnAction;

	private List<FamilyMember> members;

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clearAllFields();
		loadDesignation();
	}

	private void loadDesignation() {
		cmboDesignation.getItems().clear();
		List<Designation> designations = designationService.findAllDesignations();
		if (designations != null && !designations.isEmpty()) {
			class DesignationListCell extends ListCell<Designation> {
				protected void updateItem(Designation designation, boolean empty) {
					super.updateItem(designation, empty);
					if (designation != null) {
						setText(designation.getDesignationName());
					}
				}
			}
			cmboDesignation.setButtonCell(new DesignationListCell());
			cmboDesignation.setCellFactory(new Callback<ListView<Designation>, ListCell<Designation>>() {
				@Override
				public ListCell<Designation> call(ListView<Designation> param) {
					return new DesignationListCell();
				}
			});
			cmboDesignation.getItems().addAll(designations);
		}
	}

	private void loadSakha() {
		cmboSakha.getItems().clear();
		List<SakhaDetails> sakhaDetails = sakhaDetailsService.findAllSakhaDetails();
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

	public void clearAllFields() {
		members = new ArrayList<FamilyMember>();
		errInOfficeBarrier.setText("");
		txtdateFrom.setValue(null);
		txtdateTo.setValue(null);
		txtGroupName.setText("");
		txtMembercode.setText("");
		txtItemName.setText("");
		cmboSakha.setValue(null);
		cmboDesignation.setValue(null);
		radioUnion.setSelected(false);
		radioSakha.setSelected(false);
		gridSakha.setVisible(false);
		lblUnionName.setText("");
		tblMember.getItems().clear();
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

						if (item.isBefore(txtdateTo.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};
		txtdateTo.setDayCellFactory(dayCellFactory);
		txtdateTo.setValue(txtdateFrom.getValue().plusDays(1));
	}

	@FXML
	public void selectRadio() {
		if (radioUnion.isSelected()) {
			Union union = unionService.findAllUnion().get(0);
			if (union != null)
				lblUnionName.setText(union.getUnionName());
			gridSakha.setVisible(false);
		} else {
			lblUnionName.setText("");
			gridSakha.setVisible(true);
			loadSakha();
		}
	}

	@FXML
	public void onMemberEntered() {
		if (cmboDesignation.getValue() == null) {
			homeController.showMsg(AlertType.ERROR, "Please select designation");
		} else if (txtMembercode.getText().isEmpty()) {
			homeController.showMsg(AlertType.ERROR, "Please enter member code");
		} else {
			Member member = memberService.findMemberByMemberCode(txtMembercode.getText());
			boolean memberflag = true;
			if (member == null) {
				memberflag = false;

			}
			MemeberDetails details = memberDetailsService.findMemeberDetailsByMemberCode(txtMembercode.getText());
			boolean memberDetailflag = true;
			if (details == null) {
				memberDetailflag = false;
			}
			if (memberflag || memberDetailflag) {
				FamilyMember familyMember = new FamilyMember();
				if (member != null) {
					familyMember.setName(member.getMemberName());
					familyMember.setCode(member.getMemeberCode());
					familyMember.setPic(cmboDesignation.getValue().getDesignationName());
					familyMember.setDesignation(cmboDesignation.getValue());
				} else if (details != null) {
					familyMember.setName(details.getMemberName());
					familyMember.setCode(details.getMemberCode());
					familyMember.setPic(cmboDesignation.getValue().getDesignationName());
					familyMember.setDesignation(cmboDesignation.getValue());
				}
				columnName.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("name"));
				columnMemberCode.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("code"));
				columnDesignation.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("pic"));

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
				tblMember.getItems().add(familyMember);
				members.add(familyMember);
			} else if (!memberflag || !memberDetailflag) {
				homeController.showMsg(AlertType.ERROR,
						"Member with code " + txtMembercode.getText() + " not found !");
			}
		}
	}

	@FXML
	public void saveOfficeBarrier() {
		errInOfficeBarrier.setText("");
		if (txtdateFrom.getValue() == null) {
			errInOfficeBarrier.setText("Please select period from");
		} else if (txtdateTo.getValue() == null) {
			errInOfficeBarrier.setText("Please select period to");
		} else if (txtGroupName.getText().isEmpty()) {
			errInOfficeBarrier.setText("Please enter group name");
		} else if (txtItemName.getText().isEmpty()) {
			errInOfficeBarrier.setText("Please enter item name");
		} else if (!radioUnion.isSelected() && !radioSakha.isSelected()) {
			errInOfficeBarrier.setText("Please select either union or sakha");
		} else if (radioSakha.isSelected() && cmboSakha.getValue() == null) {
			errInOfficeBarrier.setText("Please select sakha");
		} else if (tblMember.getItems().isEmpty()) {
			errInOfficeBarrier.setText("Please enter member with designation");
		} else {
			try {
				OfficeBarrier barrier = new OfficeBarrier();
				barrier.setCreatedDate(new Date());
				barrier.setDelete(false);
				barrier.setGroupName(txtGroupName.getText());
				barrier.setItemName(txtItemName.getText());
				if (radioSakha.isSelected() && cmboSakha.getValue() == null)
					barrier.setSakhaName(cmboSakha.getValue().getSakhaCode());
				barrier.setPeriodFrom(
						Date.from(txtdateFrom.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
				barrier.setPeriodTo(
						Date.from(txtdateTo.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
				barrier.setSakhaName(cmboSakha.getValue().getSakhaCode());
				List<OfficeBarrierDetails> modals = new ArrayList<OfficeBarrierDetails>();
				if (members != null && !members.isEmpty()) {
					for (FamilyMember member : members) {
						OfficeBarrierDetails barrierDetail = new OfficeBarrierDetails();
						barrierDetail.setCreatedDate(new Date());
						barrierDetail.setDesignation(member.getDesignation());
						barrierDetail.setMemberCode(member.getCode());
						barrierDetail.setOfficeBarrier(barrier);
						modals.add(barrierDetail);
					}
				}
				barrier.setDetails(modals);
				officeBarrierService.saveOfficeBarrier(barrier);
				clearAllFields();
				homeController.showMsg(AlertType.INFORMATION, "OfficeBarrier saved successfully");
			} catch (BeansException e) {
				homeController.showMsg(AlertType.ERROR, "Error while saving OfficeBarrier !");
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
					tblMember.getItems().remove(member);
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
			loader.setLocation(getClass().getResource(Screens.ADD_OFFICE_BARRIER));
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
