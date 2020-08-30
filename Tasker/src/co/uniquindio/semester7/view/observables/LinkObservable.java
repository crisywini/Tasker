package co.uniquindio.semester7.view.observables;

import javafx.beans.property.StringProperty;

public class LinkObservable {
	private StringProperty link;
	

	public LinkObservable(StringProperty link) {
		this.link = link;
	}

	public StringProperty getLink() {
		return link;
	}

	public void setLink(StringProperty link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "LinkObservable [link=" + link.get() + "]";
	}
	

}