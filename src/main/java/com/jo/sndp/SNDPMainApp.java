package com.jo.sndp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.jo.sndp.view.controller.HomeController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class SNDPMainApp extends Application {

	private ConfigurableApplicationContext springContext = null;

	private static String[] argument;

	@Bean()
	public Stage getStage() {
		Stage newStage = new Stage();
		return newStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Task<Object> task = new Task<Object>() {
			@Override
			protected Object call() throws Exception {
				springContext = SpringApplication.run(SNDPMainApp.class, SNDPMainApp.argument);
				return null;
			}
		};
		task.setOnSucceeded(e -> {
			HomeController controller = springContext.getBean(HomeController.class);
			Parent parent = (Parent) controller.initView();
			Scene scene = new Scene(parent);
			Stage stage = springContext.getBean(Stage.class);
			stage.requestFocus();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.setTitle("SNDP");
			stage.setMaximized(true);
			stage.show();

		});
		task.setOnFailed(e -> {
			System.exit(0);
			Platform.exit();
		});
		task.run();
	}

	public static void main(String[] args) {
		SNDPMainApp.argument = args;
		launch(args);
	}

}
