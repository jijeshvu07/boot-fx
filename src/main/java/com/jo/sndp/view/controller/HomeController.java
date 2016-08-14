package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.repository.BloodRepository;
import com.jo.sndp.service.BloodGroupService;
import com.jo.sndp.util.Screens;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

@Component
public class HomeController implements BootInitializable {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	@FXML
	private ScrollPane content;
	@FXML
	private TreeView<String> menuTreeView;
	@FXML
	private TabPane tabPane;

	private ApplicationContext springContext;
	@Autowired
	private BloodGroupService bloodGroupService;
	
	@Autowired
	private BloodRepository  bloodRepository;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
      
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.springContext = springContext;
	}

	@Override
	public void initConstruct() {

	}

	@Override
	public void stage(Stage primaryStage) {

	}

	@Override
	public Node initView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(Screens.HOME));
			//loader.setController(springContext.getBean(this.getClass()));
			return loader.load();
		} catch (IOException e) {
			System.err.println("can't load scene");
			e.printStackTrace();
			return null;
		}
	}
	
	@FXML
	private void addMemberSelect(){
		 if(bloodRepository!=null){
	    	   System.out.println("service initialized");
	       }else{
	    	   System.out.println("service null"); 
	       }
	}

}
