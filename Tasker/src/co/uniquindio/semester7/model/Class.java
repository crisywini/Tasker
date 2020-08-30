package co.uniquindio.semester7.model;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private Teacher teacherAssociated;
	private int id;
	private String name;
	private List<Link> linksClass;
	private List<Student> studens;
	private List<Schedule> schedules;

	public Class(Teacher teacherAssociated, int id, String name) {
		this.teacherAssociated = teacherAssociated;
		this.id = id;
		this.name = name;
		studens = new ArrayList<Student>();
		linksClass = new ArrayList<Link>();
		schedules = new ArrayList<Schedule>();
	}

	public Teacher getTeacherAssociated() {
		return teacherAssociated;
	}

	public void setTeacherAssociated(Teacher teacherAssociated) {
		this.teacherAssociated = teacherAssociated;
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

	public List<Student> getStudens() {
		return studens;
	}

	public void setStudens(List<Student> studens) {
		this.studens = studens;
	}

	public List<Link> getLinksClass() {
		return linksClass;
	}

	public void setLinksClass(List<Link> linksClass) {
		this.linksClass = linksClass;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + "]";
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
