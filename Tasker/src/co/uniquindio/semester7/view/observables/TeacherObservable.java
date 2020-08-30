package co.uniquindio.semester7.view.observables;

import javafx.beans.property.StringProperty;

public class TeacherObservable {
	
	private StringProperty code;
	private StringProperty name;
	
	public TeacherObservable(StringProperty code, StringProperty name) {
		this.code = code;
		this.name = name;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getCode() {
		return code;
	}
	public void setCode(StringProperty code) {
		this.code = code;
	}

}
