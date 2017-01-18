package com.jo.sndp.view.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
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
import com.jo.sndp.entity.EducationQualification;
import com.jo.sndp.entity.Gender;
import com.jo.sndp.entity.Job;
import com.jo.sndp.entity.MaritalStatus;
import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.entity.PhysicalStatus;
import com.jo.sndp.entity.RelationShip;
import com.jo.sndp.service.BloodGroupService;
import com.jo.sndp.service.EducationQualificationSevice;
import com.jo.sndp.service.GenderService;
import com.jo.sndp.service.JobService;
import com.jo.sndp.service.MaritalStatusService;
import com.jo.sndp.service.MemberDetailsService;
import com.jo.sndp.service.MemberService;
import com.jo.sndp.service.PhysicalStatusService;
import com.jo.sndp.service.RelationShipService;
import com.jo.sndp.view.util.Screens;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

@Component
public class AddFamilyMemberController implements BootInitializable {
	private ApplicationContext applicationContext;
	@Autowired
	private HomeController homeController;
	@Autowired
	private AddMemberController addMemberController;
	@Autowired
	private RelationShipService relationShipService;
	@Autowired
	private BloodGroupService bloodGroupService;
	@Autowired
	private EducationQualificationSevice educationQualificationSevice;
	@Autowired
	private PhysicalStatusService physicalStatusService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDetailsService memberDetailsService;
	@Autowired
	private JobService jobService;
	@Autowired
	private MaritalStatusService maritalStatusService;
	@FXML
	private TextField txtMemberCode, txtMemberName, txtAdhaarNo, txtElectionNo, txtPanNo, txtDrivingLicence, txtMobile1,
			txtMobile2, txtEmail;
	@FXML
	private ComboBox<RelationShip> cmboRelatioShip;
	@FXML
	private ComboBox<BloodGroup> cmboBloodGroup;
	@FXML
	private DatePicker txtDob;
	@FXML
	private Label lblImgName, errInFamilyMember;
	@FXML
	private ComboBox<EducationQualification> cmboQualification;
	@FXML
	private ComboBox<PhysicalStatus> cmboPhyscialStatus;
	@FXML
	private ComboBox<Job> cmboJob;
	@FXML
	private ComboBox<Gender> cmboGender;
	@FXML
	private ComboBox<MaritalStatus> cmboMaritalstatus;
	@FXML
	private Button btnAddFamilyMember;

	private byte[] pic;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clearFields();
		loadRelatioShip();
		loadBloodGroup();
		loadQualification();
		loadPhysicalStatus();
		loadJob();
		loadGender();
		loadMaritalStatus();
	}

	private void loadMaritalStatus() {
		cmboMaritalstatus.getItems().clear();
		class MaritalListCell extends ListCell<MaritalStatus> {
			protected void updateItem(MaritalStatus status, boolean empty) {
				super.updateItem(status, empty);
				if (status != null) {
					setText(status.getStatusName());
				}
			}
		}
		cmboMaritalstatus.setButtonCell(new MaritalListCell());
		cmboMaritalstatus.setCellFactory(new Callback<ListView<MaritalStatus>, ListCell<MaritalStatus>>() {

			public ListCell<MaritalStatus> call(ListView<MaritalStatus> arg0) {
				return new MaritalListCell();
			}
		});
		List<MaritalStatus> status = maritalStatusService.findAllMaritalStatus();
		cmboMaritalstatus.getItems().addAll(status);
	}

	private void loadJob() {
		cmboJob.getItems().clear();
		class JobListCell extends ListCell<Job> {
			protected void updateItem(Job job, boolean empty) {
				super.updateItem(job, empty);
				if (job != null) {
					setText(job.getJobName());
				}
			}
		}
		cmboJob.setButtonCell(new JobListCell());
		cmboJob.setCellFactory(new Callback<ListView<Job>, ListCell<Job>>() {
			@Override
			public ListCell<Job> call(ListView<Job> param) {
				return new JobListCell();
			}
		});
		List<Job> jobs = jobService.findAllJob();
		cmboJob.getItems().addAll(jobs);
	}

	private void loadRelatioShip() {
		class RelationListCell extends ListCell<RelationShip> {
			protected void updateItem(RelationShip relationShip, boolean empty) {
				super.updateItem(relationShip, empty);
				if (relationShip != null) {
					setText(relationShip.getRelationShipName());
				}
			}
		}
		cmboRelatioShip.setButtonCell(new RelationListCell());
		cmboRelatioShip.setCellFactory(new Callback<ListView<RelationShip>, ListCell<RelationShip>>() {
			@Override
			public ListCell<RelationShip> call(ListView<RelationShip> arg0) {
				return new RelationListCell();
			}
		});
		List<RelationShip> ships = relationShipService.findAllRelationShip();
		cmboRelatioShip.getItems().addAll(ships);
	}

	private void loadBloodGroup() {
		class BloodListCell extends ListCell<BloodGroup> {
			protected void updateItem(BloodGroup group, boolean empty) {
				super.updateItem(group, empty);
				if (group != null) {
					setText(group.getGroupName());
				}
			}
		}
		cmboBloodGroup.setButtonCell(new BloodListCell());
		cmboBloodGroup.setCellFactory(new Callback<ListView<BloodGroup>, ListCell<BloodGroup>>() {

			public ListCell<BloodGroup> call(ListView<BloodGroup> arg0) {
				return new BloodListCell();
			}
		});
		List<BloodGroup> groups = bloodGroupService.findAllBloodGroup();
		cmboBloodGroup.getItems().addAll(groups);
	}

	private void loadQualification() {
		class QualificaionListCell extends ListCell<EducationQualification> {

			protected void updateItem(EducationQualification qualification, boolean empty) {
				super.updateItem(qualification, empty);
				if (qualification != null) {
					setText(qualification.getQualification());
				}
			}
		}
		cmboQualification.setButtonCell(new QualificaionListCell());
		cmboQualification
				.setCellFactory(new Callback<ListView<EducationQualification>, ListCell<EducationQualification>>() {

					public ListCell<EducationQualification> call(ListView<EducationQualification> arg0) {
						return new QualificaionListCell();
					}
				});
		List<EducationQualification> qualifications = educationQualificationSevice.findAllEducationQualification();
		cmboQualification.getItems().addAll(qualifications);
	}

	private void loadPhysicalStatus() {
		class PhysicalListCell extends ListCell<PhysicalStatus> {
			protected void updateItem(PhysicalStatus status, boolean empty) {
				super.updateItem(status, empty);
				if (status != null) {
					setText(status.getStatusName());
				}
			}
		}
		cmboPhyscialStatus.setButtonCell(new PhysicalListCell());
		cmboPhyscialStatus.setCellFactory(new Callback<ListView<PhysicalStatus>, ListCell<PhysicalStatus>>() {

			public ListCell<PhysicalStatus> call(ListView<PhysicalStatus> arg0) {
				return new PhysicalListCell();
			}
		});
		List<PhysicalStatus> status = physicalStatusService.findAllPhysicalStatus();
		cmboPhyscialStatus.getItems().addAll(status);
	}

	private void loadGender() {
		class GenderListCell extends ListCell<Gender> {
			protected void updateItem(Gender gender, boolean empty) {
				super.updateItem(gender, empty);
				if (gender != null) {
					setText(gender.getGenderName());
				}
			}
		}
		cmboGender.setButtonCell(new GenderListCell());
		cmboGender.setCellFactory(new Callback<ListView<Gender>, ListCell<Gender>>() {

			public ListCell<Gender> call(ListView<Gender> arg0) {
				return new GenderListCell();
			}
		});
		List<Gender> genders = genderService.findAllGender();
		cmboGender.getItems().addAll(genders);
	}

	public void clearFields() {
		errInFamilyMember.setVisible(false);
		txtMemberCode.setText("");
		txtMemberName.setText("");
		txtAdhaarNo.setText("");
		txtElectionNo.setText("");
		txtPanNo.setText("");
		txtDrivingLicence.setText("");
		txtMobile1.setText("");
		txtMobile2.setText("");
		txtDob.setValue(null);
		cmboRelatioShip.setValue(null);
		cmboBloodGroup.setValue(null);
		cmboQualification.setValue(null);
		cmboPhyscialStatus.setValue(null);
		cmboGender.setValue(null);
	}

	@FXML
	public void selectImg() throws IOException {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(applicationContext.getBean(Stage.class));
		if (file != null) {
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			pic = bFile;
			lblImgName.setVisible(true);
			lblImgName.setText(file.getName());
			System.out.println(file);
		} else {
			lblImgName.setVisible(false);
		}
	}

	@FXML
	public void AddFamilyClick() {
		errInFamilyMember.setVisible(false);
		if (txtMemberCode.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please enter member code");
		} else if (txtMemberName.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please enter member name");
		} else if (cmboRelatioShip.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select relation ship");
		} else if (cmboJob.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select job");
		} else if (txtDob.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select DOB");
		} else if (cmboQualification.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select qualification");
		} else if (cmboPhyscialStatus.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select physical status");
		} else if (cmboMaritalstatus.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select marital status");
		} else if (cmboGender.getValue() == null) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please select gender");
		} else if (lblImgName.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please choose image");
		} else if (txtAdhaarNo.getText().isEmpty() && txtElectionNo.getText().isEmpty() && txtPanNo.getText().isEmpty()
				&& txtDrivingLicence.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please enter  atleast 1 document");
		} else if (txtMobile1.getText().isEmpty() && txtMobile2.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please enter  atleast 1 mobile");
		} else if (txtEmail.getText().isEmpty()) {
			errInFamilyMember.setVisible(true);
			errInFamilyMember.setText("Please enter  email");
		} else {
			Member member = memberService.findMemberByMemberCode(txtMemberCode.getText());
			boolean flag = true;
			if (member != null) {
				flag = false;
				errInFamilyMember.setVisible(true);
				errInFamilyMember.setText("member code already exists");
			}
			MemeberDetails details = memberDetailsService.findMemeberDetailsByMemberCode(txtMemberCode.getText());
			if (details != null) {
				flag = false;
				errInFamilyMember.setVisible(true);
				errInFamilyMember.setText("member code already exists");
			}
			if (addMemberController.getFamilyMembers().contains(txtMemberCode.getText())) {
				flag = false;
				errInFamilyMember.setVisible(true);
				errInFamilyMember.setText("member code already exists");
			}
			if (flag) {
				FamilyMember familyMember = new FamilyMember();
				if (!txtAdhaarNo.getText().isEmpty())
					familyMember.setAdhaar(txtAdhaarNo.getText());
				familyMember.setBlood(cmboBloodGroup.getValue());
				familyMember.setCode(txtMemberCode.getText());
				Date commenceDate = Date
						.from(txtDob.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
				familyMember.setDob(DateUtility.convertUtilDatetoString(commenceDate));
				if (!txtDrivingLicence.getText().isEmpty())
					familyMember.setDrivingLicence(txtDrivingLicence.getText());
				if (!txtElectionNo.getText().isEmpty())
					familyMember.setElection(txtElectionNo.getText());
				familyMember.setGender(cmboGender.getValue());
				if (!txtMobile1.getText().isEmpty())
					familyMember.setMobile1(txtMobile1.getText());
				if (!txtMobile2.getText().isEmpty())
					familyMember.setMobile2(txtMobile2.getText());
				familyMember.setName(txtMemberName.getText());
				if (!txtPanNo.getText().isEmpty())
					familyMember.setPan(txtPanNo.getText());
				familyMember.setPhysicalStatus(cmboPhyscialStatus.getValue());
				familyMember.setJob(cmboJob.getValue());
				familyMember.setPic(lblImgName.getText());
				familyMember.setPicSource(pic);
				familyMember.setMaritalStatus(cmboMaritalstatus.getValue());
				familyMember.setQualification(cmboQualification.getValue());
				familyMember.setRelation(cmboRelatioShip.getValue());
				familyMember.setEmail(txtEmail.getText());
				addMemberController.getFamilyMembers().add(familyMember);
				addMemberController.parseMembers();

				// get a handle to the stage
				Stage stage = (Stage) btnAddFamilyMember.getScene().getWindow();
				// do what you have to do
				stage.close();
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
			loader.setLocation(getClass().getResource(Screens.ADD_FAMILY_MEMBER));
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
