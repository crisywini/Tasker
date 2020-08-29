package co.uniquindio.semester7.model;

import java.util.List;

import co.uniquindio.semester7.model.exception.EntityNullException;
import co.uniquindio.semester7.model.exception.EntityRepeatexception;

public interface AdminRemote {

	void removeClass(int idClass)throws EntityNullException
	;
	
	void addTeacher(String name)throws EntityRepeatexception;
	void removeTeacher(int id)throws EntityNullException;
	
	void addStudent(String name) throws EntityRepeatexception;
	void removeStudent(int idStudent)throws EntityNullException;
	void removeStudent(String name)throws EntityNullException;
	
	void addStudentToClass(int idClass, int idStudent)throws EntityNullException, EntityRepeatexception;
	void setTeacherToClass(int idTeacher, int idClass)throws EntityNullException;
	void addClass(int idTeacher, String name)throws EntityRepeatexception, EntityNullException;
	Class getClassById(int idClass)throws EntityNullException;
	Student getStudentById(int idStudent)throws EntityNullException;
	Student getStudentByName(String name)throws EntityNullException;
	int countStudentInClass(int idStudent, int idClass)throws EntityNullException;
	Class getClassByIdTeacher(int idTeacher)throws EntityNullException;
	
	Teacher getTeacherById(int id)throws EntityNullException;
	Teacher getTeacherByName(String name)throws EntityNullException;
	
	List<Class> getAllClasses();
	List<Student> getAllStudents();
	List<Teacher> getAllTeachers();
	List<Student> getStudentsByClass(int idClass);
	List<Class> getClassesByName(String nameClass);
	List<Teacher> getTeachersByName(String name);
}