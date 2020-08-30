package co.uniquindio.semester7.model;

public class Schedule {
	private int code;
	private String day;
	private int startHour, endHour;
	private Class associatedClass;
	
	public Schedule(String day, int startHour, int endHour, Class associatedClass) {
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.associatedClass = associatedClass;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public Class getAssociatedClass() {
		return associatedClass;
	}
	public void setAssociatedClass(Class associatedClass) {
		this.associatedClass = associatedClass;
	}
	@Override
	public String toString() {
		return "Schedule [code=" + code + ", day=" + day + ", startHour=" + startHour + ", endHour=" + endHour + "]";
	}
	

}