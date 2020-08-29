package co.uniquindio.semester7.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

	private int id;
	private String name;
	private List<Class> classes;

	public Teacher(int id, String name) {
		this.id = id;
		this.name = name;
		classes = new ArrayList<Class>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}

}