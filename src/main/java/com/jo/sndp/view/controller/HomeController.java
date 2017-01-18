package com.jo.sndp.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXSpinner;
import com.jo.sndp.config.BootInitializable;
import com.jo.sndp.view.util.Screens;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Popup;
import javafx.stage.Stage;

@Component
public class HomeController implements BootInitializable {
	private ApplicationContext springContext;
	@FXML
	private ScrollPane content;
	@FXML
	private TreeView<String> menuTreeView;
	@FXML
	private TabPane tabPane;
	private Popup popupProgressIndicator;
	@Autowired
	private AddMemberController addMemberController;
	@Autowired
	private AddOfficeBarriersController addOfficeBarriersController;
	@Autowired
	private AddSelfHelpController addSelfHelpController;
	@Autowired
	private AddDesignationController addDesignationController;
	@Autowired
	private AddSakhaController addSakhaController;
	@Autowired
	private AddUnionController addUnionController;

	public void initialize(URL arg0, ResourceBundle arg1) {
		loadTreeItems();
	}

	// loads some strings into the tree in the application UI.
	@SuppressWarnings("unchecked")
	public void loadTreeItems() {
		TreeItem<String> root = new TreeItem<String>("");
		root.setExpanded(true);
		TreeItem<String> rootDesignation = new TreeItem<String>("Designation");
		TreeItem<String> rootUnion = new TreeItem<String>("Union");
		TreeItem<String> rootSakha = new TreeItem<String>("Sakha");
		TreeItem<String> rootMember = new TreeItem<String>("Member");
		TreeItem<String> rootOfficeBarrier = new TreeItem<String>("OfficeBarrier");
		TreeItem<String> rootSelfHelp = new TreeItem<String>("SelfHelp");
		root.getChildren().addAll(rootDesignation, rootUnion, rootSakha, rootMember, rootOfficeBarrier, rootSelfHelp);
		TreeItem<String> nodeDesignationAdd = new TreeItem<String>("Add");
		rootDesignation.getChildren().addAll(nodeDesignationAdd);
		TreeItem<String> nodeUnionAdd = new TreeItem<String>("Add");
		rootUnion.getChildren().addAll(nodeUnionAdd);
		TreeItem<String> nodeSakhaAdd = new TreeItem<String>("Add");
		rootSakha.getChildren().addAll(nodeSakhaAdd);
		TreeItem<String> nodeMemberAdd = new TreeItem<String>("Add");
		rootMember.getChildren().addAll(nodeMemberAdd);
		TreeItem<String> nodeOfficeBarrierAdd = new TreeItem<String>("Add");
		rootOfficeBarrier.getChildren().addAll(nodeOfficeBarrierAdd);
		TreeItem<String> nodeSelfHelpAdd = new TreeItem<String>("Add");
		rootSelfHelp.getChildren().addAll(nodeSelfHelpAdd);

		menuTreeView.setRoot(root);
		menuTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				TreeItem<String> selectedItem = (TreeItem<String>) newValue;
				final String text = selectedItem.getValue() + " " + selectedItem.getParent().getValue();
				SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
				showProgressIndicator();
				if (text.equalsIgnoreCase("Add Designation")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addDesignationController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				} else if (text.equalsIgnoreCase("Add Union")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addUnionController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				} else if (text.equalsIgnoreCase("Add Sakha")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addSakhaController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				} else if (text.equalsIgnoreCase("Add Member")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addMemberController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				} else if (text.equalsIgnoreCase("Add OfficeBarrier")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addOfficeBarriersController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				} else if (text.equalsIgnoreCase("Add SelfHelp")) {
					Tab tabA = new Tab(text);
					ScrollPane scrollPane = new ScrollPane();
					scrollPane.setFitToHeight(true);
					scrollPane.setFitToWidth(true);
					scrollPane.setContent(addSelfHelpController.initView());
					tabA.setContent(scrollPane);
					selectionModel.select(tabA);
					tabPane.getTabs().add(tabA);
				}
				hideProgressIndicator();
			}

		});
	}

	@FXML
	private void addMemberSelect() {
		showProgressIndicator();
		final Tab tabA = new Tab("Add Member");
		final ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.setContent(addMemberController.initView());
		tabA.setContent(scrollPane);
		tabPane.getTabs().add(tabA);
		tabPane.getSelectionModel().select(tabA);
		hideProgressIndicator();
	}

	@FXML
	private void addOfficeBarrierSelect() {
		showProgressIndicator();
		final Tab tabA = new Tab("Add OfficeBarrier");
		final ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.setContent(addOfficeBarriersController.initView());
		tabA.setContent(scrollPane);
		tabPane.getTabs().add(tabA);
		tabPane.getSelectionModel().select(tabA);
		hideProgressIndicator();
	}

	@FXML
	private void addSelfHelpSelect() {
		showProgressIndicator();
		Tab tabA = new Tab("Add SelfHelp");
		final ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.setContent(addSelfHelpController.initView());
		tabA.setContent(scrollPane);
		tabPane.getTabs().add(tabA);
		hideProgressIndicator();
	}

	public ScrollPane getContent() {
		return content;
	}

	public void setContent(ScrollPane content) {
		this.content = content;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.springContext = applicationContext;
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
			loader.setLocation(getClass().getResource(Screens.HOME));
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

	public void showProgressIndicator() {
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
			Stage primaryStage = springContext.getBean(Stage.class);
			popupProgressIndicator.show(primaryStage);
			popupProgressIndicator.centerOnScreen();
		}
	}

	public void hideProgressIndicator() {
		if (popupProgressIndicator.isShowing())
			popupProgressIndicator.hide();
	}

	public void showMsg(AlertType alertType, String msg) {
		Alert alert = new Alert(alertType);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}

}
