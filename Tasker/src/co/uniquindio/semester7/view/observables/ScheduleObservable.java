package co.uniquindio.semester7.view.observables;

import javafx.beans.property.StringProperty;

public class ScheduleObservable {
	private StringProperty day;
	private StringProperty hour;

	public ScheduleObservable(StringProperty day, StringProperty hour) {
		this.day = day;
		this.hour = hour;
	}

	public StringProperty getDay() {
		return day;
	}

	public void setDay(StringProperty day) {
		this.day = day;
	}

	public StringProperty getHour() {
		return hour;
	}

	public void setHour(StringProperty hour) {
		this.hour = hour;
	}

}
