package co.uniquindio.semester7.view.observables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LinkObservable {
	private StringProperty link;
	

	public LinkObservable(String link) {
		this.link = new SimpleStringProperty(link);
	}

	public StringProperty getLink() {
		return link;
	}

	public void setLink(StringProperty link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return link.get();
	}
	

}
