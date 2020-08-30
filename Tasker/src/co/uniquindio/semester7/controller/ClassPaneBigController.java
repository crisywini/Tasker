/**
 * Sample Skeleton for 'ClassPaneBig.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import co.uniquindio.semester7.model.Class;
import co.uniquindio.semester7.main.Main;
import co.uniquindio.semester7.model.exception.EntityNullException;
import co.uniquindio.semester7.model.exception.EntityRepeatexception;
import co.uniquindio.semester7.view.observables.ClassObservable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ClassPaneBigController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="imageView"
	private ImageView imageView; // Value injected by FXMLLoader

	@FXML // fx:id="idTeacherField"
	private TextField idTeacherField; // Value injected by FXMLLoader

	@FXML // fx:id="nameClassField"
	private TextField nameClassField; // Value injected by FXMLLoader

	@FXML // fx:id="dayOneField"
	private TextField dayOneField; // Value injected by FXMLLoader

	@FXML // fx:id="startHour1Field"
	private TextField startHour1Field; // Value injected by FXMLLoader

	@FXML // fx:id="endHour1Field"
	private TextField endHour1Field; // Value injected by FXMLLoader

	@FXML // fx:id="secondDayField"
	private TextField secondDayField; // Value injected by FXMLLoader

	@FXML // fx:id="startHour2Field"
	private TextField startHour2Field; // Value injected by FXMLLoader

	@FXML // fx:id="endHour2Field"
	private TextField endHour2Field; // Value injected by FXMLLoader

	@FXML // fx:id="tableView"
	private TableView<ClassObservable> tableView; // Value injected by FXMLLoader

	@FXML // fx:id="codeTableColumn"
	private TableColumn<ClassObservable, String> codeTableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="nameTeacherTableColumn"
	private TableColumn<ClassObservable, String> nameTeacherTableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="nameClassTableColumn"
	private TableColumn<ClassObservable, String> nameClassTableColumn; // Value injected by FXMLLoader
	private MenuPaneController menuPaneController;
	private ObservableList<ClassObservable> dataClass = FXCollections.observableArrayList();

	@FXML
	void handleAddClass(ActionEvent event) {
		if (isInputValid()) {
			try {
				Main.DELEGATE.addClass(Integer.parseInt(idTeacherField.getText()), nameClassField.getText(),
						dayOneField.getText(), secondDayField.getText(), Integer.parseInt(startHour1Field.getText()),
						Integer.parseInt(endHour1Field.getText()), Integer.parseInt(startHour2Field.getText()),
						Integer.parseInt(endHour2Field.getText()));
				idTeacherField.setText("");
				nameClassField.setText("");
				dayOneField.setText("");
				startHour1Field.setText("");
				endHour1Field.setText("");
				secondDayField.setText("");
				startHour2Field.setText("");
				endHour2Field.setText("");
				initData();
				tableView.refresh();
				menuPaneController.showAlert("Se ha agregado la nueva clase, bien Crisi", "Mira Crisi",
						AlertType.INFORMATION);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (EntityRepeatexception e) {
				menuPaneController.showAlert(e.getMessage(), "Error", AlertType.ERROR);
			} catch (EntityNullException e) {
				menuPaneController.showAlert(e.getMessage(), "Error", AlertType.ERROR);
			}
		}
	}

	public boolean isInputValid() {
		boolean valid = false;
		String errorMessage = "";
		if (idTeacherField.getText().isEmpty()) {
			errorMessage += "Debes ingresar el c�digo del profe Crisi\n";
		}
		if (nameClassField.getText().isEmpty()) {
			errorMessage += "Debes ingresar el nombre de la clase Crisi\n";
		}
		if (dayOneField.getText().isEmpty()) {
			errorMessage += "Debes ingresar el d�a uno Crisi\n";
		}
		if (startHour1Field.getText().isEmpty()) {
			errorMessage += "Debes ingresar la hora de inicio de clase del d�a 1 Crisi\n";
		}
		if (endHour1Field.getText().isEmpty()) {
			errorMessage += "Debes INgresar la hora de final de clase del d�a 1 Crisi\n";
		}
		if (secondDayField.getText().isEmpty()) {
			errorMessage += "Debes ingresar el segundo d�a Crisi\n";
		}
		if (startHour2Field.getText().isEmpty()) {
			errorMessage += "Debes ingresar la hora de inicio de clase del d�a 2 Crisi\n";
		}
		if (endHour2Field.getText().isEmpty()) {
			errorMessage += "Debes ingresar la hora de final de clase del d�a 2 Crisi\n";
		}
		if (errorMessage.isEmpty()) {
			valid = true;
		} else {
			menuPaneController.showAlert(errorMessage, "Revisa tus campos", AlertType.WARNING);
		}
		return valid;
	}

	@FXML
	void handleRemoveButton(ActionEvent event) {
		if (!tableView.getSelectionModel().isEmpty()) {
			ClassObservable classO = tableView.getSelectionModel().getSelectedItem();
			int idClass = Integer.parseInt(classO.getCode().get());
			try {
				Main.DELEGATE.removeClass(idClass);
				idTeacherField.setText("");
				nameClassField.setText("");
				dayOneField.setText("");
				startHour1Field.setText("");
				endHour1Field.setText("");
				secondDayField.setText("");
				startHour2Field.setText("");
				endHour2Field.setText("");
				initData();
				tableView.refresh();
				menuPaneController.showAlert("Se ha eliminado una clase Crisi","Mira Crisi!", AlertType.WARNING);
			} catch (EntityNullException e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void handleSearchClass(ActionEvent event) {
		if (!nameClassField.getText().isEmpty()) {
			initDataNameClass();
			tableView.refresh();
		}else {
			initData();
			tableView.refresh();
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert idTeacherField != null : "fx:id=\"idTeacherField\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert nameClassField != null : "fx:id=\"nameClassField\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert dayOneField != null : "fx:id=\"dayOneField\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert startHour1Field != null : "fx:id=\"startHour1Field\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert endHour1Field != null : "fx:id=\"endHour1Field\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert secondDayField != null : "fx:id=\"secondDayField\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert startHour2Field != null : "fx:id=\"startHour2Field\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert endHour2Field != null : "fx:id=\"endHour2Field\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert codeTableColumn != null : "fx:id=\"codeTableColumn\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert nameTeacherTableColumn != null : "fx:id=\"nameTeacherTableColumn\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";
		assert nameClassTableColumn != null : "fx:id=\"nameClassTableColumn\" was not injected: check your FXML file 'ClassPaneBig.fxml'.";

	}

	public void initTableView() {
		initData();
		codeTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCode());
		nameTeacherTableColumn.setCellValueFactory(cellData -> cellData.getValue().getTeacher());
		nameClassTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
		tableView.setItems(dataClass);
		tableView.refresh();

	}

	public void initData() {
		dataClass.clear();
		List<Class> classes = Main.DELEGATE.getAllClasses();
		for (Class class1 : classes) {
			dataClass.add(new ClassObservable(class1.getId() + "", class1.getTeacherAssociated().getName(),
					class1.getName()));
		}
	}

	public void initDataNameClass() {
		dataClass.clear();
		List<Class> classes = Main.DELEGATE.getClassesByName(nameClassField.getText().trim());
		for (Class class1 : classes) {
			dataClass.add(new ClassObservable(class1.getId() + "", class1.getTeacherAssociated().getName(),
					class1.getName()));
		}
	}

	public MenuPaneController getMenuPaneController() {
		return menuPaneController;
	}

	public void setMenuPaneController(MenuPaneController menuPaneController) {
		this.menuPaneController = menuPaneController;
		initTableView();
	}
}