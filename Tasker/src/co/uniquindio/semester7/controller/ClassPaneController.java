/**
 * Sample Skeleton for 'ClassPane.fxml' Controller Class
 */

package co.uniquindio.semester7.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.uniquindio.semester7.main.Main;
import co.uniquindio.semester7.model.Link;
import co.uniquindio.semester7.view.observables.ClassObservable;
import co.uniquindio.semester7.view.observables.LinkObservable;
import co.uniquindio.semester7.view.observables.ScheduleObservable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;

public class ClassPaneController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="imageView"
	private ImageView imageView; // Value injected by FXMLLoader

	@FXML // fx:id="labelNameClass"
	private Label labelNameClass; // Value injected by FXMLLoader

	@FXML // fx:id="labelNameClass1"
	private Label labelNameClass1; // Value injected by FXMLLoader

	@FXML // fx:id="linkList"
	private ListView<LinkObservable> linkList; // Value injected by FXMLLoader

	@FXML // fx:id="scheduleTableView"
	private TableView<ScheduleObservable> scheduleTableView; // Value injected by FXMLLoader

	@FXML // fx:id="dayTableColumn"
	private TableColumn<ScheduleObservable, String> dayTableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="hourTableColumn"
	private TableColumn<ScheduleObservable, String> hourTableColumn; // Value injected by FXMLLoader
	private MenuPaneController menuPaneController;
	private ObservableList<LinkObservable> dataLinks = FXCollections.observableArrayList();
	private ClassObservable classObservable;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert labelNameClass != null : "fx:id=\"labelNameClass\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert labelNameClass1 != null : "fx:id=\"labelNameClass1\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert linkList != null : "fx:id=\"linkList\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert scheduleTableView != null : "fx:id=\"scheduleTableView\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert dayTableColumn != null : "fx:id=\"dayTableColumn\" was not injected: check your FXML file 'ClassPane.fxml'.";
		assert hourTableColumn != null : "fx:id=\"hourTableColumn\" was not injected: check your FXML file 'ClassPane.fxml'.";
	}

	public void initDataLinks() {
		dataLinks.clear();
		List<Link> links = Main.DELEGATE.getLinksByClassId(Integer.parseInt(classObservable.getCode().get()));
		for (Link link : links) {
			dataLinks.add(new LinkObservable(link.getLink()));
		}
		linkList.setItems(dataLinks);
		linkList.refresh();
	}

	public MenuPaneController getMenuPaneController() {
		return menuPaneController;
	}

	public void setMenuPaneController(MenuPaneController menuPaneController) {
		this.menuPaneController = menuPaneController;
	}

	public ClassObservable getClassObservable() {
		return classObservable;
	}

	@FXML
	void handleSelectedItem(MouseEvent event) {
//		System.out.println("SELECCIONADO: " + linkList.getSelectionModel().getSelectedItem().getLink().get());
		Clipboard cb = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString(linkList.getSelectionModel().getSelectedItem().getLink().get());
		cb.setContent(content);
	}

	public void setClassObservable(ClassObservable classObservable) {
		this.classObservable = classObservable;
		linkList.setEditable(true);
		initDataLinks();
		labelNameClass.setText(classObservable.getName().get());
	}
}
