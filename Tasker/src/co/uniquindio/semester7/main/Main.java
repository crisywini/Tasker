package co.uniquindio.semester7.main;

import java.io.IOException;


import co.uniquindio.semester7.controller.InitViewController;
import co.uniquindio.semester7.model.Delegate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final Delegate DELEGATE= new Delegate();

	@Override
	public void start(Stage primaryStage) {
		loadInit(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void loadInit(Stage primaryStage) {
		Parent parent;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/initView.fxml"));
			parent = loader.load();
			Scene scene = new Scene(parent);
			InitViewController controller = loader.getController();
			controller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
