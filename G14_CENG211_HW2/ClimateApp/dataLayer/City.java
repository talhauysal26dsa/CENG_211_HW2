package dataLayer;

import java.util.ArrayList;


public class City {
	private String name;
	private ArrayList <ClimateMeasurement> climateMeasurementArrayList;

	public City(String name, ArrayList<ClimateMeasurement> climateMeasurementArrayList) {
		 this.name = name;
		 this.climateMeasurementArrayList = climateMeasurementArrayList;
	}

	//Accessor methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList <ClimateMeasurement> getClimateMeasurementArrayList() {
		return climateMeasurementArrayList;
	}
	
	
	
	
	//ToString method
	@Override
	public String toString() {
		return name;
	}
	
	//Equals method
	@Override
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(this.getClass() != otherObject.getClass()) {
			return false;
		}
		else
		{
			City otherCity = (City) otherObject;
			return (name.equals(otherCity.name));
		}	
	}
}
