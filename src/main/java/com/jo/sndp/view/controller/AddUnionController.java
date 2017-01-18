package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.entity.District;
import com.jo.sndp.entity.PostOffice;
import com.jo.sndp.entity.State;
import com.jo.sndp.entity.Union;
import com.jo.sndp.service.DistrictService;
import com.jo.sndp.service.PostOfficeService;
import com.jo.sndp.service.StateService;
import com.jo.sndp.service.UnionService;
import com.jo.sndp.view.util.Screens;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
@Component
public class AddUnionController implements BootInitializable {
	private ApplicationContext applicationContext;
	@Autowired
	private StateService stateService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private PostOfficeService postOfficeService;
	@Autowired
	private UnionService unionService;
	@Autowired
	private HomeController homeController;
	@FXML
	private Label errInUnion;
	@FXML
	private ComboBox<String> cmboState = new ComboBox<String>();
	@FXML
	private ComboBox<String> cmboDistrict = new ComboBox<String>();
	@FXML
	private ComboBox<String> cmboPostOffice = new ComboBox<String>();
	@FXML
	private TextField txtUnionName, txtUnionCode, txtTown, txtBuildingNo, txtLandLine1, txtLandLine2, txtEmail;

	private ObservableList<String> stateList = FXCollections.observableArrayList();
	private ObservableList<String> districtList = FXCollections.observableArrayList();
	private ObservableList<String> postOfficeList = FXCollections.observableArrayList();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errInUnion.setVisible(false);
		districtList.clear();
		postOfficeList.clear();
		clearAllFields();
		showState();
	}

	private void clearAllFields() {
		txtUnionName.setText("");
		txtUnionCode.setText("");
		txtTown.setText("");
		txtBuildingNo.setText("");
		txtLandLine1.setText("");
		txtLandLine2.setText("");
		txtEmail.setText("");
		errInUnion.setVisible(false);
		cmboState.setValue(null);
		cmboDistrict.setValue(null);
		cmboPostOffice.setValue(null);
	}

	public void showState() {
		stateList.clear();
		List<State> states = stateService.findAllState();
		cmboState.setItems(stateList);
		for (State state : states) {
			stateList.add(state.getStateName());
		}
	}

	@FXML
	public void selectState() {
		if (cmboState.getValue() != null) {
			districtList.clear();
			postOfficeList.clear();
			List<District> districts = districtService.findAllDistrictByStateName(cmboState.getValue());
			cmboDistrict.setItems(districtList);
			for (District district : districts) {
				districtList.add(district.getDistrictName());
			}
		}
	}

	@FXML
	public void selectDistrict() {
		if (cmboDistrict.getValue() != null) {
			postOfficeList.clear();
			List<PostOffice> postOffices = postOfficeService.findAllPostofficeByDistrictName(cmboDistrict.getValue());
			cmboPostOffice.setItems(postOfficeList);
			for (PostOffice office : postOffices) {
				postOfficeList.add(office.getPostOfficeName());
			}
		}
	}

	@FXML
	public void onAddUnionClick() {
		// Simple expression to find a valid e-mail address in a file
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		//final String NUMBER_PATTERN = "/[^0-9]/";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(txtEmail.getText());
		errInUnion.setVisible(false);
		if (txtUnionName.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter union name");
		} else if (txtUnionCode.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter union code");
		} else if (cmboState.getValue() == null) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please select state");
		} else if (cmboDistrict.getValue() == null) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please select district");
		} else if (cmboPostOffice.getValue() == null) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please select postoffice");
		} else if (txtTown.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter town");
		} else if (txtBuildingNo.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter building no.");
		} else if (txtLandLine1.getText().isEmpty() && txtLandLine2.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter atleast 1 landline no.");
		}  else if (txtEmail.getText().isEmpty()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter email");
		} else if (!matcher.matches()) {
			errInUnion.setVisible(true);
			errInUnion.setText("Please enter a vailid email");
		} else {
			Union union = unionService.findUnionByUnionName(txtUnionName.getText());
			boolean flag = true;
			if (union != null) {
				errInUnion.setVisible(true);
				errInUnion.setText("Union name is already exists");
				flag = false;
			}
			union = unionService.findUnionByUnionCode(txtUnionCode.getText());
			if (union != null) {
				errInUnion.setVisible(true);
				errInUnion.setText("Union code is already exists");
				flag = false;
			}
			if (flag) {
				try {
					union = new Union();
					union.setUnionName(txtUnionName.getText());
					union.setUnionCode(txtUnionCode.getText());
					PostOffice postOffice = postOfficeService.findPostOfficeByName(cmboPostOffice.getValue());
					union.setState(postOffice.getDistrict().getState());
					union.setDistrict(postOffice.getDistrict());
					union.setPostOffice(postOffice);
					union.setEmailId(txtEmail.getText());
					union.setBuildingNo(txtBuildingNo.getText());
					if (!txtLandLine1.getText().isEmpty())
						union.setLandPhone1(txtLandLine1.getText());
					if (!txtLandLine2.getText().isEmpty())
						union.setLandPhone2(txtLandLine2.getText());
					union.setDelete(false);
					union.setCreatedDate(new Date());
					unionService.saveUnion(union);
					homeController.showMsg(AlertType.INFORMATION, "Union saved successfully");
					clearAllFields();
				} catch (BeansException e) {
					homeController.showMsg(AlertType.ERROR, "Error while saving Union !");
				}
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
			loader.setLocation(getClass().getResource(Screens.ADD_UNION));
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
