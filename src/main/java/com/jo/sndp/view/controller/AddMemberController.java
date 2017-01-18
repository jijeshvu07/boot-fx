package com.jo.sndp.view.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.aitrich.utitity.date.DateUtility;
import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.dao.modal.FamilyMember;
import com.jo.sndp.entity.BloodGroup;
import com.jo.sndp.entity.District;
import com.jo.sndp.entity.EducationQualification;
import com.jo.sndp.entity.FinanceStatus;
import com.jo.sndp.entity.Gender;
import com.jo.sndp.entity.Job;
import com.jo.sndp.entity.MaritalStatus;
import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.entity.PanchayathOffice;
import com.jo.sndp.entity.PhysicalStatus;
import com.jo.sndp.entity.PostOffice;
import com.jo.sndp.entity.SakhaDetails;
import com.jo.sndp.entity.State;
import com.jo.sndp.entity.Union;
import com.jo.sndp.entity.VillageOffice;
import com.jo.sndp.entity.Ward;
import com.jo.sndp.service.BloodGroupService;
import com.jo.sndp.service.DistrictService;
import com.jo.sndp.service.EducationQualificationSevice;
import com.jo.sndp.service.FinanceStatusService;
import com.jo.sndp.service.GenderService;
import com.jo.sndp.service.JobService;
import com.jo.sndp.service.MaritalStatusService;
import com.jo.sndp.service.MemberDetailsService;
import com.jo.sndp.service.MemberService;
import com.jo.sndp.service.PanchayathOfficeService;
import com.jo.sndp.service.PhysicalStatusService;
import com.jo.sndp.service.PostOfficeService;
import com.jo.sndp.service.SakhaDetailsService;
import com.jo.sndp.service.StateService;
import com.jo.sndp.service.UnionService;
import com.jo.sndp.service.VillageOfficeService;
import com.jo.sndp.service.WardService;
import com.jo.sndp.view.util.Screens;
import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
@Component
public class AddMemberController implements BootInitializable {
	private ApplicationContext applicationContext;
	@Autowired
	private HomeController homeController;
	@Autowired
	private UnionService unionService;
	@Autowired
	private StateService stateService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private BloodGroupService bloodGroupService;
	@Autowired
	private EducationQualificationSevice educationQualificationSevice;
	@Autowired
	private PhysicalStatusService physicalStatusService;
	@Autowired
	private JobService jobService;
	@Autowired
	private MaritalStatusService maritalStatusService;
	@Autowired
	private FinanceStatusService financeStatusService;
	@Autowired
	private SakhaDetailsService sakhaDetailsService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private PostOfficeService postOfficeService;
	@Autowired
	private VillageOfficeService villageOfficeService;
	@Autowired
	private PanchayathOfficeService panchayathOfficeService;
	@Autowired
	private WardService wardService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDetailsService memberDetailsService;
	@Autowired
	private AddFamilyMemberController addFamilyMemberController;
	private List<FamilyMember> familyMembers;
	@FXML
	private TextField txtParentName, txtParentHouseNo, txtTown, txtParentAdhaarNo, txtParentElectionNo, txtParentPanNo,
			txtParentDrivingLicence, txtParentLandLine, txtParentMobile1, txtParentMobile2, txtParentEmail,
			txtMemberCode;

	@FXML
	private ComboBox<Union> cmboUnion;
	@FXML
	private ComboBox<State> cmboState;
	@FXML
	private ComboBox<Gender> cmboParentGender;
	@FXML
	private ComboBox<BloodGroup> cmboParentBloodGroup;
	@FXML
	private ComboBox<EducationQualification> cmboParentQualification;
	@FXML
	private ComboBox<PhysicalStatus> cmboParentPhyscialStatus;
	@FXML
	private ComboBox<Job> cmboParentJob;
	@FXML
	private ComboBox<MaritalStatus> cmboParentMaritalStatus;
	@FXML
	private ComboBox<FinanceStatus> cmboParentFinancialStatus;
	@FXML
	private ComboBox<SakhaDetails> cmboSakha;
	@FXML
	private ComboBox<District> cmboDistrict;
	@FXML
	private ComboBox<PostOffice> cmboPostOffice;
	@FXML
	private ComboBox<VillageOffice> cmboVillage;
	@FXML
	private ComboBox<PanchayathOffice> cmboPanchayath;
	@FXML
	private ComboBox<Ward> cmboWard;
	@FXML
	private Label errInMember, txtImgName;
	@FXML
	private TableView<FamilyMember> tblFamilyMembers;
	@FXML
	private TableColumn<FamilyMember, String> columnName;
	@FXML
	private TableColumn<FamilyMember, String> columnCode;
	@FXML
	private TableColumn<FamilyMember, String> columnDOB;
	@FXML
	private TableColumn<FamilyMember, Integer> columnAge;
	@FXML
	private TableColumn columnAction;
	@FXML
	private DatePicker txtDateofBirth;
	private byte[] parentPic;



	public void initialize(URL arg0, ResourceBundle arg1) {
		loadUnion();
		loadstate();
		loadGender();
		loadBloodGroup();
		loadQualification();
		loadPhysicalStatus();
		loadJob();
		loadMaritalStatus();
		loadFinancialStatus();
		clearAllFields();
		familyMembers = new ArrayList<FamilyMember>();
	}

	private void loadFinancialStatus() {
		cmboParentFinancialStatus.getItems().clear();
		class FinancialListCell extends ListCell<FinanceStatus> {

			protected void updateItem(FinanceStatus status, boolean empty) {
				super.updateItem(status, empty);
				if (status != null) {
					setText(status.getFinanceStatusName());
				}
			}
		}
		cmboParentFinancialStatus.setButtonCell(new FinancialListCell());
		cmboParentFinancialStatus.setCellFactory(new Callback<ListView<FinanceStatus>, ListCell<FinanceStatus>>() {

			public ListCell<FinanceStatus> call(ListView<FinanceStatus> arg0) {
				return new FinancialListCell();
			}
		});
		List<FinanceStatus> status = financeStatusService.findAllFinanceStatus();
		cmboParentFinancialStatus.getItems().addAll(status);
	}

	private void loadMaritalStatus() {
		cmboParentMaritalStatus.getItems().clear();
		class MaritalListCell extends ListCell<MaritalStatus> {

			protected void updateItem(MaritalStatus status, boolean empty) {
				super.updateItem(status, empty);
				if (status != null) {
					setText(status.getStatusName());
				}
			}
		}
		cmboParentMaritalStatus.setButtonCell(new MaritalListCell());
		cmboParentMaritalStatus.setCellFactory(new Callback<ListView<MaritalStatus>, ListCell<MaritalStatus>>() {

			public ListCell<MaritalStatus> call(ListView<MaritalStatus> arg0) {
				return new MaritalListCell();
			}
		});
		List<MaritalStatus> status = maritalStatusService.findAllMaritalStatus();
		cmboParentMaritalStatus.getItems().addAll(status);
	}

	private void loadJob() {
		cmboParentJob.getItems().clear();
		class JobListCell extends ListCell<Job> {

			protected void updateItem(Job job, boolean empty) {
				super.updateItem(job, empty);
				if (job != null) {
					setText(job.getJobName());
				}
			}
		}
		cmboParentJob.setButtonCell(new JobListCell());
		cmboParentJob.setCellFactory(new Callback<ListView<Job>, ListCell<Job>>() {

			public ListCell<Job> call(ListView<Job> arg0) {
				return new JobListCell();
			}
		});
		List<Job> jobs = jobService.findAllJob();
		cmboParentJob.getItems().addAll(jobs);
	}

	private void loadPhysicalStatus() {
		cmboParentPhyscialStatus.getItems().clear();
		class PhysicalListCell extends ListCell<PhysicalStatus> {

			protected void updateItem(PhysicalStatus status, boolean empty) {
				super.updateItem(status, empty);
				if (status != null) {
					setText(status.getStatusName());
				}
			}
		}
		cmboParentPhyscialStatus.setButtonCell(new PhysicalListCell());
		cmboParentPhyscialStatus.setCellFactory(new Callback<ListView<PhysicalStatus>, ListCell<PhysicalStatus>>() {

			public ListCell<PhysicalStatus> call(ListView<PhysicalStatus> arg0) {
				return new PhysicalListCell();
			}
		});
		List<PhysicalStatus> status = physicalStatusService.findAllPhysicalStatus();
		cmboParentPhyscialStatus.getItems().addAll(status);
	}

	private void loadQualification() {
		cmboParentQualification.getItems().clear();
		class QualificaionListCell extends ListCell<EducationQualification> {

			protected void updateItem(EducationQualification qualification, boolean empty) {
				super.updateItem(qualification, empty);
				if (qualification != null) {
					setText(qualification.getQualification());
				}
			}
		}
		cmboParentQualification.setButtonCell(new QualificaionListCell());
		cmboParentQualification
				.setCellFactory(new Callback<ListView<EducationQualification>, ListCell<EducationQualification>>() {

					public ListCell<EducationQualification> call(ListView<EducationQualification> arg0) {
						return new QualificaionListCell();
					}
				});
		List<EducationQualification> qualifications = educationQualificationSevice.findAllEducationQualification();
		cmboParentQualification.getItems().addAll(qualifications);
	}

	private void loadBloodGroup() {
		cmboParentBloodGroup.getItems().clear();
		class BloodListCell extends ListCell<BloodGroup> {

			protected void updateItem(BloodGroup group, boolean empty) {
				super.updateItem(group, empty);
				if (group != null) {
					setText(group.getGroupName());
				}
			}
		}
		cmboParentBloodGroup.setButtonCell(new BloodListCell());
		cmboParentBloodGroup.setCellFactory(new Callback<ListView<BloodGroup>, ListCell<BloodGroup>>() {

			public ListCell<BloodGroup> call(ListView<BloodGroup> arg0) {
				return new BloodListCell();
			}
		});
		List<BloodGroup> groups = bloodGroupService.findAllBloodGroup();
		cmboParentBloodGroup.getItems().addAll(groups);
	}

	private void loadGender() {
		cmboParentGender.getItems().clear();
		class GenderListCell extends ListCell<Gender> {

			protected void updateItem(Gender gender, boolean empty) {
				super.updateItem(gender, empty);
				if (gender != null) {
					setText(gender.getGenderName());
				}
			}
		}
		cmboParentGender.setButtonCell(new GenderListCell());
		cmboParentGender.setCellFactory(new Callback<ListView<Gender>, ListCell<Gender>>() {

			public ListCell<Gender> call(ListView<Gender> arg0) {
				return new GenderListCell();
			}
		});
		List<Gender> genders = genderService.findAllGender();
		cmboParentGender.getItems().addAll(genders);
	}

	private void loadstate() {
		cmboState.getItems().clear();
		class StateListCell extends ListCell<State> {

			protected void updateItem(State state, boolean empty) {
				super.updateItem(state, empty);
				if (state != null) {
					setText(state.getStateName());
				}
			}
		}
		cmboState.setButtonCell(new StateListCell());
		cmboState.setCellFactory(new Callback<ListView<State>, ListCell<State>>() {

			public ListCell<State> call(ListView<State> arg0) {
				return new StateListCell();
			}
		});
		List<State> states = stateService.findAllState();
		cmboState.getItems().addAll(states);
	}

	private void loadUnion() {
		cmboUnion.getItems().clear();
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
		List<Union> unions = unionService.findAllUnion();
		cmboUnion.getItems().addAll(unions);
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

	@FXML
	public void selectState() {
		cmboDistrict.getItems().clear();
		if (cmboState.getValue() != null) {
			State state = cmboState.getValue();
			List<District> districts = districtService.findAllDistrictByStateName(state.getStateName());
			if (districts != null && !districts.isEmpty()) {
				class DistrictListCell extends ListCell<District> {

					protected void updateItem(District district, boolean empty) {
						super.updateItem(district, empty);
						if (district != null) {
							setText(district.getDistrictName());
						}
					}
				}
				cmboDistrict.setButtonCell(new DistrictListCell());
				cmboDistrict.setCellFactory(new Callback<ListView<District>, ListCell<District>>() {

					public ListCell<District> call(ListView<District> arg0) {
						return new DistrictListCell();
					}
				});
				cmboDistrict.getItems().addAll(districts);
			}
		}
	}

	@FXML
	public void selectDistrict() {
		cmboPostOffice.getItems().clear();
		cmboVillage.getItems().clear();
		cmboPanchayath.getItems().clear();
		if (cmboDistrict.getValue() != null) {
			District district = cmboDistrict.getValue();
			List<PostOffice> postOffices = postOfficeService
					.findAllPostofficeByDistrictName(district.getDistrictName());
			if (postOffices != null && !postOffices.isEmpty()) {
				class PostOfficeListCell extends ListCell<PostOffice> {

					protected void updateItem(PostOffice office, boolean empty) {
						super.updateItem(office, empty);
						if (office != null) {
							setText(office.getPostOfficeName());
						}
					}
				}
				cmboPostOffice.setButtonCell(new PostOfficeListCell());
				cmboPostOffice.setCellFactory(new Callback<ListView<PostOffice>, ListCell<PostOffice>>() {

					public ListCell<PostOffice> call(ListView<PostOffice> arg0) {
						return new PostOfficeListCell();
					}
				});
				cmboPostOffice.getItems().addAll(postOffices);
			}
			List<VillageOffice> villageOffices = villageOfficeService.findAllVillageOfficeByDistrict(district.getId());
			if (villageOffices != null && !villageOffices.isEmpty()) {
				class VillageListCell extends ListCell<VillageOffice> {

					protected void updateItem(VillageOffice office, boolean empty) {
						super.updateItem(office, empty);
						if (office != null) {
							setText(office.getVillageName());
						}
					}
				}
				cmboVillage.setButtonCell(new VillageListCell());
				cmboVillage.setCellFactory(new Callback<ListView<VillageOffice>, ListCell<VillageOffice>>() {

					public ListCell<VillageOffice> call(ListView<VillageOffice> arg0) {
						return new VillageListCell();
					}
				});
				cmboVillage.getItems().addAll(villageOffices);
			}
			// cmboPanchayath
			List<PanchayathOffice> panchayathOffices = panchayathOfficeService
					.findAllPanchayathOfficeByDistrict(district.getId());
			if (panchayathOffices != null && !panchayathOffices.isEmpty()) {
				class PanchayathListCell extends ListCell<PanchayathOffice> {

					protected void updateItem(PanchayathOffice office, boolean empty) {
						super.updateItem(office, empty);
						if (office != null) {
							setText(office.getPanchayathName());
						}
					}
				}
				cmboPanchayath.setButtonCell(new PanchayathListCell());
				cmboPanchayath.setCellFactory(new Callback<ListView<PanchayathOffice>, ListCell<PanchayathOffice>>() {

					public ListCell<PanchayathOffice> call(ListView<PanchayathOffice> arg0) {
						return new PanchayathListCell();
					}
				});
				cmboPanchayath.getItems().addAll(panchayathOffices);
			}
		}
	}

	@FXML
	public void selectPanchayathoffice() {
		cmboWard.getItems().clear();
		if (cmboPanchayath.getValue() != null) {
			PanchayathOffice panchayathOffice = cmboPanchayath.getValue();
			List<Ward> wards = wardService.findAllWardsByPanchayath(panchayathOffice.getId());
			if (wards != null && !wards.isEmpty()) {
				class WardListCell extends ListCell<Ward> {

					protected void updateItem(Ward ward, boolean empty) {
						super.updateItem(ward, empty);
						if (ward != null) {
							setText(ward.getWardName());
						}
					}
				}
				cmboWard.setButtonCell(new WardListCell());
				cmboWard.setCellFactory(new Callback<ListView<Ward>, ListCell<Ward>>() {
					public ListCell<Ward> call(ListView<Ward> param) {
						return new WardListCell();
					}
				});
				cmboWard.getItems().addAll(wards);
			}
		}
	}

	@FXML
	public void clickMoreFamilyMember() throws IOException {
		ScrollPane page =  new ScrollPane(addFamilyMemberController.initView());
		// Create the dialog Stage.
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Add Member");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(applicationContext.getBean(Stage.class));
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		// Show the dialog and wait until the user closes it
		dialogStage.showAndWait();
	}

	public void parseMembers() {
		columnName.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("name"));
		columnCode.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("code"));
		columnDOB.setCellValueFactory(new PropertyValueFactory<FamilyMember, String>("dob"));
		columnAge.setCellValueFactory(new PropertyValueFactory<FamilyMember, Integer>("age"));
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

		tblFamilyMembers.getItems().setAll(familyMembers);
	}

	public void clearAllFields() {
		txtImgName.setVisible(false);
		errInMember.setVisible(false);
		txtParentName.setText("");
		txtParentHouseNo.setText("");
		txtMemberCode.setText("");
		txtTown.setText("");
		txtParentAdhaarNo.setText("");
		txtParentElectionNo.setText("");
		txtParentPanNo.setText("");
		txtParentDrivingLicence.setText("");
		txtParentLandLine.setText("");
		txtParentMobile1.setText("");
		txtParentMobile2.setText("");
		txtParentEmail.setText("");
		txtDateofBirth.setValue(null);
		cmboUnion.setValue(null);
		cmboSakha.setValue(null);
		cmboState.setValue(null);
		cmboDistrict.setValue(null);
		cmboPanchayath.setValue(null);
		cmboPostOffice.setValue(null);
		cmboVillage.setValue(null);
		cmboWard.setValue(null);
		cmboParentGender.setValue(null);
		cmboParentBloodGroup.setValue(null);
		cmboParentQualification.setValue(null);
		cmboParentPhyscialStatus.setValue(null);
		cmboParentJob.setValue(null);
		cmboParentMaritalStatus.setValue(null);
		cmboParentFinancialStatus.setValue(null);
		tblFamilyMembers.getItems().clear();
	}

	@FXML
	private void saveMember() {
		errInMember.setVisible(false);
		if (txtImgName.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter member name");
		} else if (txtParentHouseNo.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter house no/name");
		} else if (txtMemberCode.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter member code");
		} else if (cmboUnion.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select union");
		} else if (cmboSakha.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select sakha");
		} else if (cmboState.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select state");
		} else if (cmboDistrict.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select district");
		} else if (cmboPanchayath.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select panchayath office");
		} else if (cmboPostOffice.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select post office");
		} else if (cmboVillage.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select village office");
		} else if (txtTown.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter town");
		} else if (cmboWard.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select ward");
		} else if (cmboParentGender.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select gender");
		} else if (txtDateofBirth.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select DOB");
		} else if (cmboParentQualification.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select education qualification");
		} else if (cmboParentPhyscialStatus.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select physical status");
		} else if (cmboParentJob.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select job");
		} else if (cmboParentMaritalStatus.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select marital status");
		} else if (cmboParentFinancialStatus.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select financial status");
		} else if (txtParentAdhaarNo.getText().isEmpty() && txtParentElectionNo.getText().isEmpty()
				&& txtParentPanNo.getText().isEmpty() && txtParentDrivingLicence.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter  atleast 1 document");
		} else if (txtImgName.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please choose image");
		} else if (txtParentLandLine.getText().isEmpty() && txtParentMobile1.getText().isEmpty()
				&& txtParentMobile2.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter  atleast 1 contact number");
		} else if (txtParentEmail.getText().isEmpty()) {
			errInMember.setVisible(true);
			errInMember.setText("Please enter email address");
		} else if (cmboParentBloodGroup.getValue() == null) {
			errInMember.setVisible(true);
			errInMember.setText("Please select blood group");
		} else {
			Member member = memberService.findMemberByMemberCode(txtMemberCode.getText());
			boolean flag = true;
			if (member != null) {
				flag = false;
				errInMember.setVisible(true);
				errInMember.setText("member code already exists");
			}
			MemeberDetails details = memberDetailsService.findMemeberDetailsByMemberCode(txtMemberCode.getText());
			if (details != null) {
				flag = false;
				errInMember.setVisible(true);
				errInMember.setText("member code already exists");
			}
			if (flag) {
				try {
					member = new Member();
					if (!txtParentAdhaarNo.getText().isEmpty())
						member.setAadhaarNo(txtParentAdhaarNo.getText());
					member.setBloodGroup(cmboParentBloodGroup.getValue());
					member.setCreatedDate(new Date());
					member.setDelete(false);
					member.setDistrict(cmboDistrict.getValue());
					Date dob = Date
							.from(txtDateofBirth.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
					member.setDob(dob);
					if (!txtParentDrivingLicence.getText().isEmpty())
						member.setDrivingLicenceNo(txtParentDrivingLicence.getText());
					member.setEducationQualification(cmboParentQualification.getValue());
					if (!txtParentElectionNo.getText().isEmpty())
						member.setElectionIdNo(txtParentElectionNo.getText());
					member.setEmailId(txtParentEmail.getText());
					member.setFinanceStatus(cmboParentFinancialStatus.getValue());
					member.setGender(cmboParentGender.getValue());
					member.setHouseNo(txtParentHouseNo.getText());
					member.setJob(cmboParentJob.getValue());
					if (!txtParentLandLine.getText().isEmpty())
						member.setLandLineNo(txtParentLandLine.getText());
					member.setMaritalStatus(cmboParentMaritalStatus.getValue());
					member.setMemberName(txtParentName.getText());
					member.setMemeberCode(txtMemberCode.getText());
					if (!txtParentMobile1.getText().isEmpty())
						member.setMobile1(txtParentMobile1.getText());
					if (!txtParentMobile2.getText().isEmpty())
						member.setMobile2(txtParentMobile2.getText());
					member.setPanchayathOffice(cmboPanchayath.getValue());
					if (!txtParentPanNo.getText().isEmpty())
						member.setPanNo(txtParentPanNo.getText());
					member.setPhoto(parentPic);
					member.setPhysicalStatus(cmboParentPhyscialStatus.getValue());
					member.setPostOffice(cmboPostOffice.getValue());
					member.setSakhaDetails(cmboSakha.getValue());
					member.setState(cmboState.getValue());
					member.setTown(txtTown.getText());
					member.setUnion(cmboUnion.getValue());
					member.setVillageOffice(cmboVillage.getValue());
					member.setWard(cmboWard.getValue());
					List<MemeberDetails> modals = null;
					if (familyMembers != null && !familyMembers.isEmpty()) {
						modals = new ArrayList<MemeberDetails>();
						for (FamilyMember familyMember : familyMembers) {
							MemeberDetails modal = new MemeberDetails();
							if (familyMember.getAdhaar() != null)
								modal.setAdhaarNo(familyMember.getAdhaar());
							modal.setBloodGroup(familyMember.getBlood());
							modal.setCreatedDate(new Date());
							modal.setDelete(false);
							modal.setDob(DateUtility.convertStringToUtilDate(familyMember.getDob()));
							if (familyMember.getDrivingLicence() != null)
								modal.setDrivingLicenceNo(familyMember.getDrivingLicence());
							modal.setEducationQualification(familyMember.getQualification());
							if (familyMember.getElection() != null)
								modal.setElectionIdNo(familyMember.getElection());
							modal.setEmailId(familyMember.getEmail());
							modal.setGender(familyMember.getGender());
							modal.setJob(familyMember.getJob());
							modal.setMaritalStatus(familyMember.getMaritalStatus());
							modal.setMember(member);
							modal.setMemberCode(familyMember.getCode());
							modal.setMemberName(familyMember.getName());
							if (familyMember.getMobile1() != null)
								modal.setMobile1(familyMember.getMobile1());
							if (familyMember.getMobile2() != null)
								modal.setMobile2(familyMember.getMobile2());
							if (familyMember.getPan() != null)
								modal.setPanNo(familyMember.getPan());
							modal.setPhoto(familyMember.getPicSource());
							modal.setPhysicalStatus(familyMember.getPhysicalStatus());
							modal.setRelationShip(familyMember.getRelation());
							modals.add(modal);
						}
					}

					if (modals != null && !modals.isEmpty())
						memberService.saveMember(member, modals);
					else
						memberService.saveMember(member);
					clearAllFields();
					homeController.showMsg(AlertType.INFORMATION, "Member saved successfully");
				} catch (Exception e) {
					homeController.showMsg(AlertType.ERROR, "Error while saving Member !");
				}
			}
		}
	}

	@FXML
	public void onFileChooserClick() throws IOException {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(applicationContext.getBean(Stage.class));
		if (file != null) {
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			parentPic = bFile;
			txtImgName.setVisible(true);
			txtImgName.setText(file.getName());
			System.out.println(file);
		} else {
			txtImgName.setVisible(false);
		}

	}

	

	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
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
					familyMembers.remove(member);
					tblFamilyMembers.getItems().remove(member);
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
			loader.setLocation(getClass().getResource(Screens.ADD_MEMBER));
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
