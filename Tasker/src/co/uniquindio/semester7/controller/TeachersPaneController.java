/**
 * Sample Skeleton for 'TeachersPane.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.semester7.view.observables.TeacherObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class TeachersPaneController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="tableView"
    private TableView<TeacherObservable> tableView; // Value injected by FXMLLoader

    @FXML // fx:id="codeColumn"
    private TableColumn<TeacherObservable, String> codeColumn; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<TeacherObservable, String> nameColumn; // Value injected by FXMLLoader
    
    private MenuPaneController menuPaneController;

    @FXML
    void handleAddTeacherButton(ActionEvent event) {

    }

    @FXML
    void handleDeleteTeacherButton(ActionEvent event) {

    }

    @FXML
    void handleSearchTeacherButton(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'TeachersPane.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'TeachersPane.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'TeachersPane.fxml'.";
        assert codeColumn != null : "fx:id=\"codeColumn\" was not injected: check your FXML file 'TeachersPane.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'TeachersPane.fxml'.";

    }

	public MenuPaneController getMenuPaneController() {
		return menuPaneController;
	}

	public void setMenuPaneController(MenuPaneController menuPaneController) {
		this.menuPaneController = menuPaneController;
	}
}
