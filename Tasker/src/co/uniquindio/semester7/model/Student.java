package co.uniquindio.semester7.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private String name;
	private List<Class> classes;

	
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		classes = new ArrayList<Class>();
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}