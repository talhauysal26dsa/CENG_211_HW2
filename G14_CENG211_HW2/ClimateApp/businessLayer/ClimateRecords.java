package businessLayer;

import java.util.ArrayList;
import dataLayer.City;
import dataLayer.FileIO;
import dataLayer.Country;

public class ClimateRecords {
	GenerateMeasurements measurementGenerator = new GenerateMeasurements();
	FileIO fileIO = new FileIO();
	ArrayList<String> arrayListOfCountryAndCityNames = fileIO.readFile();
	private ArrayList<City> arrayListOfCity = new ArrayList<City>();
	private ArrayList<Country> arrayListOfCountry = new ArrayList<Country>();
	
	public ClimateRecords() {
		this.createCityObjects();
		this.createCountryObjects();
	}
	
	// Method for creating list consist of cities
	private ArrayList<City> createCityObjects(){	
		for (String name :  arrayListOfCountryAndCityNames) {
			if(arrayListOfCountryAndCityNames.indexOf(name)%4 != 0) {
				City city = new City(name, measurementGenerator.generateMeasurementList());		
				arrayListOfCity.add(city);
			}
		}
		return arrayListOfCity;
	}

	// Method for creating list consist of countries
	private ArrayList<Country> createCountryObjects(){
		for (String name :  arrayListOfCountryAndCityNames) {
			if(arrayListOfCountryAndCityNames.indexOf(name)%4 == 0) {
				Country country = new Country(name, measurementGenerator.generateTemperatureForCountry());	
				arrayListOfCountry.add(country);			
			}
		}
		return arrayListOfCountry;
	}
	
	//Accessor methods for lists
	public ArrayList<City> getArrayListOfCity() {
		return arrayListOfCity;
	}

	public ArrayList<Country> getArrayListOfCountry() {
		return arrayListOfCountry;
	}
}
