package dataLayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileIO {
	ArrayList<String> cityAndCountryNames;
	
	public FileIO() {	
		cityAndCountryNames = new ArrayList<String>();
	}
	
	//Method for reading country and city names from file
	public ArrayList<String> readFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("countries_and_cities.csv"))) {
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	StringTokenizer wordFinder = new StringTokenizer(line, ",");
		        // Process each line here
		    	while (wordFinder.hasMoreTokens()) {	 
		    		 cityAndCountryNames.add(wordFinder.nextToken().trim());
		    	}   
		    }
		}catch (IOException e) {
		    e.printStackTrace();}
		return cityAndCountryNames;		
	}
}
