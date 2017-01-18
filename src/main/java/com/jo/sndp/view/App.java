/*package com.jo.sndp.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gvj.sndp.view.util.Screens;
import com.gvj.sndp.view.util.ScreensController;
import com.jfoenix.controls.JFXSpinner;
import com.jo.sndp.service.BusinessLogicException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class App extends Application {
	private static ApplicationContext appContext;
	private Stage primaryStage;
	private static App instance;
	private ScreensController mainContainer;
	private Popup popupProgressIndicator;

	public static void main(String[] args) throws BusinessLogicException {
		appContext = new ClassPathXmlApplicationContext("application-config.xml");
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		instance = this;
		primaryStage = stage;
		primaryStage.getIcons().add(new Image("/img/icon.ico"));
		primaryStage.setMaximized(true);
		mainContainer = new ScreensController();
		mainContainer.loadScreen(Screens.HOME);
		mainContainer.setScreen(Screens.HOME);
		Scene scene = new Scene(mainContainer);
	   // scene.getStylesheets().add("/css/MainStyle.css");
		primaryStage.setTitle("SNDP");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public static App getInstance() {
		return instance;
	}

	public static void setInstance(App instance) {
		App.instance = instance;
	}

	public ScreensController getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(ScreensController mainContainer) {
		this.mainContainer = mainContainer;
	}

	public static ApplicationContext getAppContext() {
		return appContext;
	}

	public static void setAppContext(ApplicationContext appContext) {
		App.appContext = appContext;
	}

	

	*//**
	 * create and show progress indicator.
	 * 
	 * @param myController
	 *//*
	public void showProgressIndicator(ScreensController myController) {
		myController.setDisable(true);
		if (popupProgressIndicator == null) {
			JFXSpinner spinner = new JFXSpinner();
			spinner.setLayoutX(0);
			spinner.setLayoutY(0);
			spinner.setPrefHeight(200);
			spinner.setPrefWidth(200);
			popupProgressIndicator = new Popup();
			popupProgressIndicator.getContent().add(spinner);
		}
		if (!popupProgressIndicator.isShowing()) {
			popupProgressIndicator.show(primaryStage);
			popupProgressIndicator.centerOnScreen();
		}
	}

	*//**
	 * for hiding progress indicator.
	 * 
	 * @param myController
	 *//*
	public void hideProgressIndicator(ScreensController myController) {
		myController.setDisable(false);
		if (popupProgressIndicator.isShowing())
			popupProgressIndicator.hide();
	}
	
	public void showMsg(AlertType alertType,String msg){
		Alert alert = new Alert(alertType);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}

}
*/