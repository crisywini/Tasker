/**
 * Sample Skeleton for 'MenuPane.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.uniquindio.semester7.main.Main;
import co.uniquindio.semester7.model.Class;
import co.uniquindio.semester7.model.exception.EntityNullException;
import co.uniquindio.semester7.view.observables.ClassObservable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MenuPaneController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="imageView"
	private ImageView imageView; // Value injected by FXMLLoader

	@FXML // fx:id="labelName"
	private Label labelName; // Value injected by FXMLLoader
	@FXML // fx:id="modifyPane"
	private BorderPane modifyPane; // Value injected by FXMLLoader

	@FXML // fx:id="treeViewElements"
	private TreeView<String> treeViewElements; // Value injected by FXMLLoader
	private InitViewController initViewController;
	private final Node rootIcon = new ImageView(new Image(Main.class.getResourceAsStream("/images/mas.png")));
	TreeItem<String> rootNode = new TreeItem<String>("Categorias", rootIcon);

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'MenuPane.fxml'.";
		assert labelName != null : "fx:id=\"labelName\" was not injected: check your FXML file 'MenuPane.fxml'.";
		assert treeViewElements != null : "fx:id=\"treeViewElements\" was not injected: check your FXML file 'MenuPane.fxml'.";
		imageView.setImage(new Image(Main.class.getResourceAsStream("/images/SuperAdmin.jpeg")));
		initTreeView();
	}

	public void initTreeView() {
		Node icon1 = new ImageView(new Image(Main.class.getResourceAsStream("/images/noticias.png")));
		Node icon2 = new ImageView(new Image(Main.class.getResourceAsStream("/images/services.png")));
		Node icon3 = new ImageView(new Image(Main.class.getResourceAsStream("/images/BigPuzzle.png")));

		rootNode.setExpanded(true);// Setea que se abra al principio
		TreeItem<String> classes = new TreeItem<String>("Clases", icon1);
		List<Class> classesList = Main.DELEGATE.getAllClasses();
		for (Class class1 : classesList) {
			TreeItem<String> classAux = new TreeItem<String>(class1.getName());
			classes.getChildren().add(classAux);
		}

		TreeItem<String> teachers = new TreeItem<String>("Profes", icon2);
		TreeItem<String> schedule = new TreeItem<String>("Horario", icon3);
		rootNode.getChildren().add(classes);
		rootNode.getChildren().add(teachers);
		rootNode.getChildren().add(schedule);

		treeViewElements.setRoot(rootNode);
	}

	@FXML
	void handleClickedTreeItem(MouseEvent event) {
		TreeItem<String> item = treeViewElements.getSelectionModel().getSelectedItem();
		if (item.getValue().equalsIgnoreCase("profes")) {
			showTeachersPane();

		}
		if (item.getValue().equalsIgnoreCase("clases")) {
			showClassPane(item.getValue());
		}
		// Hacer for e iterar sobre todos los nombres de las clases para verificar
		// cuando sea correcto
		List<Class> classesList = Main.DELEGATE.getAllClasses();
		for (Class class1 : classesList) {
			if (class1.getName().equalsIgnoreCase(item.getValue())) {
				showClassPane(item.getValue());
			}
		}
		
		if (item.getValue().equalsIgnoreCase("horario")) {
			showSchedulePane();
		}
	}

	public void showTeachersPane() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/TeachersPane.fxml"));
			VBox parent = loader.load();
			TeachersPaneController controller = loader.getController();
			controller.setMenuPaneController(this);
			modifyPane.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showClassPane(String nameClass) {
		if (!nameClass.equalsIgnoreCase("clases")) {
			try {
				Class classAux = Main.DELEGATE.getClassByName(nameClass);
				ClassObservable classAuxObservable = new ClassObservable(classAux.getId() + "",
						classAux.getTeacherAssociated().getName(), classAux.getName());
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ClassPane.fxml"));
				VBox parent = loader.load();
				ClassPaneController controller = loader.getController();
				controller.setMenuPaneController(this);
				controller.setClassObservable(classAuxObservable);
				modifyPane.setCenter(parent);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (EntityNullException e) {
				e.printStackTrace();
			}
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ClassPaneBig.fxml"));
				VBox parent = loader.load();
				ClassPaneBigController controller = loader.getController();
				controller.setMenuPaneController(this);
				modifyPane.setCenter(parent);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void showSchedulePane() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/SchedulePane.fxml"));
			VBox parent = loader.load();
			modifyPane.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAlert(String contentText, String title, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setContentText(contentText);
		alert.setTitle(title);
		alert.setHeaderText("");
		alert.showAndWait();
	}

	public InitViewController getInitViewController() {
		return initViewController;
	}

	public void setInitViewController(InitViewController initViewController) {
		this.initViewController = initViewController;
	}
}
