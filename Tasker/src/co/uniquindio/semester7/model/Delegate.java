package co.uniquindio.semester7.model;

import java.util.List;

import co.uniquindio.semester7.model.exception.EntityNullException;
import co.uniquindio.semester7.model.exception.EntityRepeatexception;

public class Delegate implements AdminRemote {

	private Admin admin;
	public static Delegate delegate = instance();

	public Delegate() {
		admin = new Admin();
	}

	private static Delegate instance() {
		if (delegate == null) {
			delegate = new Delegate();
		}
		return delegate;
	}

	@Override
	public void removeClass(int idClass) throws EntityNullException {
		admin.removeClass(idClass);
	}

	@Override
	public void addTeacher(String name) throws EntityRepeatexception {
		admin.addTeacher(name);
	}

	@Override
	public void removeTeacher(int id) throws EntityNullException {
		admin.removeTeacher(id);
	}

	@Override
	public void addStudent(String name) throws EntityRepeatexception {
		admin.addStudent(name);
	}

	@Override
	public void removeStudent(int idStudent) throws EntityNullException {
		admin.removeStudent(idStudent);
	}

	@Override
	public void removeStudent(String name) throws EntityNullException {
		admin.removeStudent(name);
	}

	@Override
	public void addStudentToClass(int idClass, int idStudent) throws EntityNullException, EntityRepeatexception {
		admin.addStudentToClass(idClass, idStudent);
	}

	@Override
	public void setTeacherToClass(int idTeacher, int idClass) throws EntityNullException {
		admin.setTeacherToClass(idTeacher, idClass);
	}

	@Override
	public void addClass(int idTeacher, String name, String day1, String day2, int startHour1, int endHour1,
			int startHour2, int endHour2) throws EntityRepeatexception, EntityNullException {
		admin.addClass(idTeacher, name, day1, day2, startHour1, endHour1, startHour2, endHour2);
	}

	@Override
	public Class getClassById(int idClass) throws EntityNullException {
		return admin.getClassById(idClass);
	}

	@Override
	public Student getStudentById(int idStudent) throws EntityNullException {
		return admin.getStudentById(idStudent);
	}

	@Override
	public Student getStudentByName(String name) throws EntityNullException {
		return admin.getStudentByName(name);
	}

	@Override
	public int countStudentInClass(int idStudent, int idClass) throws EntityNullException {
		return admin.countStudentInClass(idStudent, idClass);
	}

	@Override
	public Class getClassByIdTeacher(int idTeacher) throws EntityNullException {
		return admin.getClassByIdTeacher(idTeacher);
	}

	@Override
	public void addLinkToClass(int idClass, String link) throws EntityNullException {
		admin.addLinkToClass(idClass, link);
	}

	@Override
	public Teacher getTeacherById(int id) throws EntityNullException {
		return admin.getTeacherById(id);
	}

	@Override
	public Teacher getTeacherByName(String name) throws EntityNullException {
		return admin.getTeacherByName(name);
	}

	@Override
	public List<Class> getAllClasses() {
		return admin.getAllClasses();
	}

	@Override
	public List<Student> getAllStudents() {
		return admin.getAllStudents();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return admin.getAllTeachers();
	}

	@Override
	public List<Student> getStudentsByClass(int idClass) {
		return admin.getStudentsByClass(idClass);
	}

	@Override
	public List<Class> getClassesByName(String nameClass) {
		return admin.getClassesByName(nameClass);
	}

	@Override
	public List<Teacher> getTeachersByName(String name) {
		return admin.getTeachersByName(name);
	}

	@Override
	public List<Link> getAllLinks() {
		return admin.getAllLinks();
	}

	@Override
	public List<Schedule> getAllSchedules() {
		return admin.getAllSchedules();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}