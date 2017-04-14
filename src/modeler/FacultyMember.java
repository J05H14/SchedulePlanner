package modeler;

import java.util.*;

public class FacultyMember extends Person {
	
	private int id;
	private List<Course> schedule;

	public FacultyMember(int streetNum, String streetName, String city, String state, String country, String name, int id, List<Course> schedule) {
		super(streetNum, streetName, city, state, country, name);
		this.id = id;
		this.schedule = schedule;
	}
	
	public String toString(){
		return "ID: " + id + " " + super.toString() + " Schedule: " + schedule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Course> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Course> schedule) {
		this.schedule = schedule;
	}

}
