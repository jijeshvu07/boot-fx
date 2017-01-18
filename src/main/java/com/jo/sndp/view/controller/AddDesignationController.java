package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.entity.Designation;
import com.jo.sndp.service.DesignationService;
import com.jo.sndp.view.util.Screens;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@Component
public class AddDesignationController implements BootInitializable {
	private ApplicationContext applicationContext;
	@FXML
	private TextField txtDesignationName;
	@FXML
	private Label errInSaveDesignation;
	@FXML
	private GridPane designationGrid;
	@Autowired
	private  DesignationService designationService;
	@Autowired
	private HomeController homeController;

	public void initialize(URL location, ResourceBundle resources) {
		txtDesignationName.setText("");
		errInSaveDesignation.setVisible(false);
	}

	@FXML
	private void onSaveDesignationClick() {

		errInSaveDesignation.setVisible(false);
		if (txtDesignationName.getText().isEmpty()) {
			errInSaveDesignation.setVisible(true);
			errInSaveDesignation.setText("Please enter designation");
		} else {
			Designation designation = designationService.findDesignationByName(txtDesignationName.getText());
			if (designation != null) {
				errInSaveDesignation.setVisible(true);
				errInSaveDesignation.setText("Designation already exists");
			} else {
				designation = new Designation();
				designation.setDesignationName(txtDesignationName.getText());
				designation.setDelete(false);
				designation.setCreatedDate(new Date());

				txtDesignationName.setText("");
				// Make your Progress visible here
				try {
					designationService.saveDesignation(designation);
					homeController.showMsg(AlertType.INFORMATION, "Designation saved successfully");
				} catch (Exception e) {
					homeController.showMsg(AlertType.ERROR, "Error while saving Designation !");
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
			loader.setLocation(getClass().getResource(Screens.ADD_DESIGNATION));
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
