package dataLayer;

import java.util.ArrayList;

public class Country {
	
	private String name;
	private ArrayList<Temperature> countryWideAverageTemperatureList;
	
	public Country(String name, ArrayList<Temperature> countryWideAverageTemperatureList ) {
		this.name = name;
		this.countryWideAverageTemperatureList = countryWideAverageTemperatureList;		
	}

	//Accessor methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Temperature> getCountryWideAverageTemperatureList() {
		return countryWideAverageTemperatureList;
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
			Country otherCountry = (Country) otherObject;
			return (name.equals(otherCountry.name));
		}	
	}
	
	
}
