package modeler;

public class Person extends Address {

	private String name;
	
	public Person(int streetNum, String streetName, String city, String state, String country, String name) {
		super(streetNum, streetName, city, state, country);
		this.name = name;
		
	}
	
	public String toString(){
		return name + " from " + super.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
