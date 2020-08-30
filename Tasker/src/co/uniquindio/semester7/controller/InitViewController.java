/**
 * Sample Skeleton for 'InitView.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.semester7.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class InitViewController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="rootPane"
	private BorderPane rootPane; // Value injected by FXMLLoader
	private Main main;
	MenuPaneController menuPaneController;
	VBox menuPane;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'InitView.fxml'.";
		showMenuPane();
	}

	public void showMenuPane() {
		if (menuPane == null) {
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MenuPane.fxml"));
				menuPane = loader.load();
				menuPaneController = loader.getController();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		menuPaneController.setInitViewController(this);
		rootPane.setCenter(menuPane);
	}


	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
