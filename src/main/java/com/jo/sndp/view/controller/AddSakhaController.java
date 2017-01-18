package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.entity.SakhaDetails;
import com.jo.sndp.entity.Union;
import com.jo.sndp.service.SakhaDetailsService;
import com.jo.sndp.service.UnionService;
import com.jo.sndp.view.util.Screens;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
@Component
public class AddSakhaController implements BootInitializable {
    private ApplicationContext applicationContext;
    @Autowired
	private UnionService unionService;
    @Autowired
	private SakhaDetailsService sakhaDetailsService;
    @Autowired
    private HomeController homeController;

	@FXML
	private Label errInAddSakha;
	@FXML
	private TextField txtUnionCode, txtSakhaCode, txtSakhaName, txtPlace, txtMemberMaleCount, txtMemberFeMaleCount;
	@FXML
	private DatePicker txtDate;
	@FXML
	private ComboBox<String> cmboStatus = new ComboBox<String>();
	private ObservableList<String> statusOBVList = FXCollections.observableArrayList("Active", "Inactive");

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errInAddSakha.setVisible(false);
		clearAllFields();
		cmboStatus.setItems(statusOBVList);
	}

	private void clearAllFields() {
		errInAddSakha.setVisible(false);
		txtUnionCode.setText("");
		txtSakhaCode.setText("");
		txtSakhaName.setText("");
		txtPlace.setText("");
		txtMemberMaleCount.setText("");
		txtMemberFeMaleCount.setText("");
		LocalDate today = LocalDate.now();
		txtDate.setValue(today);
		cmboStatus.setValue(null);
	}

	@FXML
	public void onSakhaSaveClick() {
		errInAddSakha.setVisible(false);
		if (txtUnionCode.getText().isEmpty()) {
			errInAddSakha.setVisible(true);
			errInAddSakha.setText("Please enter union code");
		} else if (txtSakhaCode.getText().isEmpty()) {
			errInAddSakha.setVisible(true);
			errInAddSakha.setText("Please enter sakha code");
		} else if (txtSakhaName.getText().isEmpty()) {
			errInAddSakha.setVisible(true);
			errInAddSakha.setText("Please enter sakha name");
		} else if (txtPlace.getText().isEmpty()) {
			errInAddSakha.setVisible(true);
			errInAddSakha.setText("Please enter place");
		} else if (cmboStatus.getValue() == null) {
			errInAddSakha.setVisible(true);
			errInAddSakha.setText("Please select status");
		} else {
			Union union = unionService.findUnionByUnionCode(txtUnionCode.getText());
			boolean flag = true;
			if (union == null) {
				errInAddSakha.setVisible(true);
				errInAddSakha.setText("Invalid union code");
				flag = false;
			}
			SakhaDetails sakhaDetails = sakhaDetailsService.findSakhaDetailsBySakhaName(txtSakhaName.getText());
			if (sakhaDetails != null) {
				errInAddSakha.setVisible(true);
				errInAddSakha.setText("Sakha name already exists");
				flag = false;
			}
			sakhaDetails = sakhaDetailsService.findSakhaDetailsBySakhaCode(txtSakhaCode.getText());
			if (sakhaDetails != null) {
				errInAddSakha.setVisible(true);
				errInAddSakha.setText("Sakha code already exists");
				flag = false;
			}
			if (flag) {
				try {
					sakhaDetails = new SakhaDetails();
					sakhaDetails.setUnion(union);
					sakhaDetails.setSakhaName(txtSakhaName.getText());
					sakhaDetails.setSakhaCode(txtSakhaCode.getText());
					sakhaDetails.setPlace(txtPlace.getText());
					sakhaDetails.setMemberCountFeMale(0);
					sakhaDetails.setMemberCountMale(0);
					sakhaDetails.setStatus(cmboStatus.getValue());
					sakhaDetails.setCreatedDate(new Date());
					sakhaDetails.setDelete(false);
					Date commenceDate = Date.from(txtDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
					sakhaDetails.setDateCommencement(commenceDate);
					sakhaDetailsService.saveSakhaDetails(sakhaDetails);
					clearAllFields();
					homeController.showMsg(AlertType.INFORMATION, "Sakha saved successfully");
				} catch (Exception e) {
					homeController.showMsg(AlertType.ERROR, "Error while saving Sakha !");
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
			loader.setLocation(getClass().getResource(Screens.ADD_SAKHA));
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
