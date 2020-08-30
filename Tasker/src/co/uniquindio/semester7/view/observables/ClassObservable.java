package co.uniquindio.semester7.view.observables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassObservable {
	private StringProperty code, teacher, name;

	public ClassObservable(String code, String teacher, String name) {
		this.code = new SimpleStringProperty(code);
		this.teacher = new SimpleStringProperty(teacher);
		this.name = new SimpleStringProperty(name);
	}

	public StringProperty getCode() {
		return code;
	}

	public void setCode(StringProperty code) {
		this.code = code;
	}

	public StringProperty getTeacher() {
		return teacher;
	}

	public void setTeacher(StringProperty teacher) {
		this.teacher = teacher;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

}
