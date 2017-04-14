package modeler;

import java.util.*;

public class Student extends Person {

	private long cin;
	private List<Course> schedule;
	
	public Student(int streetNum, String streetName, String city, String state, String country, String name, long cin, List<Course> schedule) {
		super(streetNum, streetName, city, state, country, name);
		this.cin = cin;
		this.schedule = schedule;
	}
	
	public String toString(){
		return "CIN: " + cin + " " + super.toString() + " Schedule: " + schedule;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public List<Course> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Course> schedule) {
		this.schedule = schedule;
	}

}
