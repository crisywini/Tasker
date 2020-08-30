/**
 * Sample Skeleton for 'SchedulePane.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.semester7.main.Main;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SchedulePaneController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="imageView"
	private ImageView imageView; // Value injected by FXMLLoader

	@FXML // fx:id="scheduleImageView"
	private ImageView scheduleImageView; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'SchedulePane.fxml'.";
		assert scheduleImageView != null : "fx:id=\"scheduleImageView\" was not injected: check your FXML file 'SchedulePane.fxml'.";
		imageView.setImage(new Image(Main.class.getResourceAsStream("/images/folder.png")));
	}
}
