package presentationLayer;

import java.util.ArrayList;
import java.util.Scanner;
import businessLayer.ClimateApp;
import businessLayer.ClimateRecords;
import dataLayer.City;
import dataLayer.Country;

public class Menu {
	private ClimateApp climateApp;
	private ClimateRecords climateRecords = new ClimateRecords();
	private String userInput="";
	Scanner scanner = new Scanner(System.in);
	
	private final String[] MONTHS;
	public Menu() {
		MONTHS = new String[]{"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
		climateApp = new ClimateApp();
	}
	
	//Menu
	public void menuOutput() {
		while(!userInput.equals("7")) {
			System.out.println("[1] Calculate average temperature for a country according to temperature unit and year.");
			System.out.println("[2] Calculate average temperature for a city according to temperature unit and year");
			System.out.println("[3] Calculate average wind speed for a city according to speed unit and year.");
			System.out.println("[4] Calculate average humidity of a city for every year.");
			System.out.println("[5] Count how many times a year a specific radiation intensity value appears");
			System.out.println("[6] Calculate the \"felt temperature\" value for a specific month");
			System.out.println("[7] Exit the application");
			
	        // Ask the user for input
	        System.out.println("Please select an option: ");

	        // Read the user input       
	        userInput = scanner.nextLine(); 
	        userInput= checkOption(userInput, 1, 7);	        	        	        	  	        
	        if(userInput.equals("1")) {
	        	firstOption();	        		        	
	        }	        
	        else if(userInput.equals("2")) {
	        	secondOption();
	        }	        
	        else if(userInput.equals("3")) {
	        	thirdOption();	        	
	        }
	        else if(userInput.equals("4")) {
	        	fourthOption();	        	
	        }	        
	        else if(userInput.equals("5")) {
	        	fifthOption(); 	
	        }
	        else if(userInput.equals("6")) {
	        	sixthOption();
	        }
	        else if (userInput.equals("7")) {
	        	System.out.println("==> Closing the application..."); 
	        	scanner.close();
	        }
		}
	}
	
	//Methods for options in menu
	private void firstOption() {
	    String measurement = "";
	    String year = "";
	    System.out.println("Enter the name of the country: ");
	    String selectedCountry = scanner.nextLine();
	    selectedCountry = checkCountry(selectedCountry);
	    selectedCountry = selectedCountry.toLowerCase();
	    char firstCharacter = selectedCountry.charAt(0);
	    selectedCountry = Character.toUpperCase(firstCharacter)+ selectedCountry.substring(1);
	    System.out.println("[1] Celsius [2] Fahrenheit [3] Kelvin");
	    System.out.println("Please select the temperature unit: ");	    
	    String selectedMeasurementChoice = scanner.nextLine();
	    selectedMeasurementChoice =checkOption(selectedMeasurementChoice, 1, 3);
	    switch (selectedMeasurementChoice) {
	        case "1":
	            measurement = "Celsius";
	            break;
	        case "2":
	            measurement = "Fahrenheit";
	            break;
	        case "3":
	            measurement = "Kelvin";
	            break;
	       
	    }
	    
	    System.out.println("[1] 2020 [2] 2021 [3] 2022");
	    System.out.println("Please select the year: ");
	    String selectedYear = scanner.nextLine();
	    selectedYear= checkOption(selectedYear, 1, 3);
	    switch (selectedYear) {
	        case "1":
	            year = "2020";
	            break;
	        case "2":
	            year = "2021";
	            break;
	        case "3":
	            year = "2022";
	            break;
	        
	    }
	    double avgTempCount = climateApp.getAverageTemperatureForACountry(selectedCountry, Integer.parseInt(selectedMeasurementChoice), Integer.parseInt(selectedYear));
	    System.out.println("==> Average temperature of " + selectedCountry + " in " + measurement + " in " + year + ": " + String.format("%.2f", avgTempCount) + "\n");
	    System.out.println("*****************************************************************************\n");	
	}
	
	private void secondOption() {
	    System.out.println("Enter the name of the city: ");
	    String selectedCity = scanner.nextLine();
	    selectedCity=checkCity(selectedCity);
	    selectedCity = selectedCity.toLowerCase();
	    char firstCharacter = selectedCity.charAt(0);
	    selectedCity = Character.toUpperCase(firstCharacter)+ selectedCity.substring(1);
	    System.out.println("[1] Celsius [2] Fahrenheit [3] Kelvin");
	    System.out.println("Please select the temperature unit: ");
	    String selectedMeasurementChoice = scanner.nextLine();
	    String measurement = "";
	    selectedMeasurementChoice =checkOption(selectedMeasurementChoice, 1, 3);
	    switch (selectedMeasurementChoice) {
	        case "1":
	            measurement = "Celsius";
	            break;
	        case "2":
	            measurement = "Fahrenheit";
	            break;
	        case "3":
	            measurement = "Kelvin";
	            break;
	       
	    }
	    System.out.println("[1] 2020 [2] 2021 [3] 2022");
	    System.out.println("Please select the year: ");
	    String selectedYear = scanner.nextLine();
	    String year = "";
	    selectedYear =checkOption(selectedYear, 1, 3);
	    switch (selectedYear) {
	        case "1":
	            year = "2020";
	            break;
	        case "2":
	            year = "2021";
	            break;
	        case "3":
	            year = "2022";
	            break;
	        
	    }
	    double avgTempCount = climateApp.getAverageTemperatureForaCity(selectedCity, Integer.parseInt(selectedMeasurementChoice), Integer.parseInt(selectedYear));
	    System.out.println("==> Average temperature of " + selectedCity + " in " + measurement + " in " + year + ": " + String.format("%.2f", avgTempCount) + "\n");
	    System.out.println("*****************************************************************************\n");	    	
	}
	
	private void thirdOption() {
		System.out.println("Enter the name of the city: ");
	    String selectedCity = scanner.nextLine();
	    selectedCity=checkCity(selectedCity);
	    selectedCity = selectedCity.toLowerCase();
	    char firstCharacter = selectedCity.charAt(0);
	    selectedCity = Character.toUpperCase(firstCharacter)+ selectedCity.substring(1);
	    System.out.println("[1] M/S [2] KM/H");
	    System.out.println("Please select the speed unit: ");
	    String selectedUnitOfSpeed = scanner.nextLine();
	    String unitOfSpeed = "";
	    selectedUnitOfSpeed=checkOption(selectedUnitOfSpeed, 1, 2);
	    switch (selectedUnitOfSpeed) {
	        case "1":
	            unitOfSpeed = "M/S";
	            break;
	        case "2":
	            unitOfSpeed = "KM/H";
	            break;
	        
	    }
	    for(int i=0;i<MONTHS.length;i++) 
	    	System.out.print("["+(i+1)+"]"+MONTHS[i]+" ");
	    System.out.println("\nPlease select the month: ");
	    String selectedMonth = scanner.nextLine();
	    selectedMonth = checkOption(selectedMonth, 1, 12);
	    double avgWindForaMonth = climateApp.averageWindSpeed(selectedCity, Integer.parseInt(selectedUnitOfSpeed), Integer.parseInt(selectedMonth)); // MONTHS[selectedMonth -1]
	    System.out.println("==> Average wind of " + selectedCity + " at " + MONTHS[Integer.parseInt(selectedMonth)-1] + " in " + unitOfSpeed + ": " + String.format("%.2f", avgWindForaMonth) + "\n");
	    System.out.println("*****************************************************************************\n");
	}
	
	private void fourthOption() {
		System.out.println("Enter the name of the city: ");
    	String selectedCity = scanner.nextLine();       	
    	selectedCity=checkCity(selectedCity);
    	selectedCity = selectedCity.toLowerCase();
	    char firstCharacter = selectedCity.charAt(0);
	    selectedCity = Character.toUpperCase(firstCharacter)+ selectedCity.substring(1);
    	double avgHumidityForaMonth = climateApp.getAverageHumidity(selectedCity);
    	System.out.println("==> Average Humidity of 3 years:  "+ String.format("%.2f", avgHumidityForaMonth)+"\n");
    	System.out.println("*****************************************************************************\n");
	}
	
	private void fifthOption() {
		System.out.println("Enter the name of the city: ");
	    String selectedCity = scanner.nextLine();
	    selectedCity=checkCity(selectedCity);
	    selectedCity = selectedCity.toLowerCase();
	    char firstCharacter = selectedCity.charAt(0);
	    selectedCity = Character.toUpperCase(firstCharacter)+ selectedCity.substring(1);
	    System.out.println("[1] Low [2] Medium [3] High");
	    System.out.println("Please select a radiation intensity value: ");
	    String selectedIntensity = scanner.nextLine();
	    selectedIntensity=checkOption(selectedIntensity, 1, 3);
	    String intensity = "";
	    switch (selectedIntensity) {
	        case "1":
	            intensity = "LOW";
	            break;
	        case "2":
	            intensity = "MEDIUM";
	            break;
	        case "3":
	            intensity = "HIGH";
	            break;
	       
	    }
	    System.out.println("[1] 2020 [2] 2021 [3] 2022");
	    System.out.println("Please select the year: ");
	    String selectedYear = scanner.nextLine();
	    selectedYear=checkOption(selectedYear, 1, 3);
	    String year = "";
	    switch (selectedYear) {
	        case "1":
	            year = "2020";
	            break;
	        case "2":
	            year = "2021";
	            break;
	        case "3":
	            year = "2022";
	            break;
	     
	    }
	    int countOfIntensity = climateApp.findRadiationIntensity(selectedCity, intensity, Integer.parseInt(selectedYear));
	    System.out.println("==> Total count of " + intensity.toLowerCase() + " radiation intensity in " + selectedCity + " in " + year + ": " + countOfIntensity + "\n");
	    System.out.println("*****************************************************************************\n");
	}
	
	private void sixthOption() {
		System.out.println("Enter the name of the city: ");
	    String selectedCity = scanner.nextLine();
	    selectedCity=checkCity(selectedCity);
	    selectedCity = selectedCity.toLowerCase();
	    char firstCharacter = selectedCity.charAt(0);
	    selectedCity = Character.toUpperCase(firstCharacter)+ selectedCity.substring(1);
	    System.out.println("[1] 2020 [2] 2021 [3] 2022");
	    System.out.println("Please select the year: ");
	    String selectedYear = scanner.nextLine();
	    selectedYear=checkOption(selectedYear,1,3);
	    String year = "";
	    switch (selectedYear) {
	        case "1":
	            year = "2020";
	            break;
	        case "2":
	            year = "2021";
	            break;
	        case "3":
	            year = "2022";
	            break;
	       
	    }
	    for(int i=0;i<MONTHS.length;i++) 
	    	System.out.print("["+(i+1)+"]"+MONTHS[i]+" ");
	    System.out.println("\nPlease select the month: ");
	    String selectedMonth = scanner.nextLine();
	    selectedMonth = checkOption(selectedMonth, 1, 12);
	    double feltTemp = climateApp.getFeltTemperatureForYearAndMonthForCity(selectedCity, Integer.parseInt(selectedYear), Integer.parseInt(selectedMonth));
	    System.out.println("==> Felt Temperature of " + selectedCity + " in " + year + " in " +  MONTHS[Integer.parseInt(selectedMonth)-1] + ": " + String.format("%.2f", feltTemp) + "\n");
	    System.out.println("*****************************************************************************\n");
	}
	
	//This methods return the string list of city objects
	private ArrayList<String> cityNamesList() {
		ArrayList<City> cities = climateRecords.getArrayListOfCity();
        ArrayList<String> cityNamesList = new ArrayList<String>();
        for (City city : cities) {
            String cityName = city.getName();
            cityNamesList.add(cityName);  
        }
		return cityNamesList;
	}
	
	//This methods return the string list of city objects
	private ArrayList<String> countryNamesList() {
        ArrayList<Country> countries = climateRecords.getArrayListOfCountry();
        ArrayList<String> countryNamesList = new ArrayList<String>();
        for (Country country : countries) {
            String countriesName = country.getName();
            countryNamesList.add(countriesName); 
        }
		return countryNamesList;
	}
	
	//Methods for validation
	private String checkCity(String input) {
		while (!isValidCity(input)) {
	        System.out.println("Invalid city. Please enter a valid city.");
	        System.out.print("Enter a city: ");
	        input = scanner.nextLine();
	    }
		return input;
	}
	
	private String checkCountry(String input) {
		while (!isValidCountry(input)) {
	        System.out.println("Invalid country. Please enter a valid country.");
	        System.out.print("Enter a country: ");
	        input = scanner.nextLine();
	    }
		return input;
	}

	private String checkOption(String input, int firstInterval, int lastInterval) {
		
		//CHECKED IF THE FIRST INPUT İS NUMBER NOR NUT
		if (!isNumber(input)) {
			
			//IF NOT NUMBER WE GET INPUT AGAIN
			while (!(isNumber(input))) {
		        System.out.println("Incorrect option input! Please reenter another option input: ");
		        input = scanner.nextLine();
		    }
			//IF INPUT IS NUMBER AGAIN WE CONTROL IF THE USER WILL INPUT STRING AGAIN OR NOT
			while(!(firstInterval <= Integer.parseInt(input) && Integer.parseInt(input) <= lastInterval)^!(isNumber(input))){
				//IF THAT IS THE CAASE WE GET INPUT AGAIN
				while (!(isNumber(input))) {
			        System.out.println("Incorrect option input! Please reenter another option input: ");
			        input = scanner.nextLine();
			    }
				//IF USERS INPUT IS LIKE FIRST INT AND AGAIN STRING WE CHECKED HERE
				
				while( !(firstInterval <= Integer.parseInt(input) && Integer.parseInt(input) <= lastInterval)) {
					System.out.println("Incorrect option input! Please reenter another option input: ");
					input = scanner.nextLine();
					//IF USER TRIES TO INPUT STRING AGAIN AND AGAIN AFTE TH FIRST INPUT IS NUMBER WE CHECK AND WE GET IT AGAIN
					while (!(isNumber(input))) {
						 try {
					        	
					            Integer.parseInt(input);
					            
					        } catch (NumberFormatException e) {
					        	System.out.println("Incorrect option input! Please reenter another option input: ");
					        	input = scanner.nextLine();
      
					        } 
					}
	        	
			        }
				}
		}//in this block we check if user inputs first number then string ....
		else if(isNumber(input)) {
			while(!(firstInterval <= Integer.parseInt(input) && Integer.parseInt(input) <= lastInterval)^!(isNumber(input))){
				
				while (!(isNumber(input))) {
			        System.out.println("Incorrect option input! Please reenter another option input: ");
			        input = scanner.nextLine();
			    }
				while( !(firstInterval <= Integer.parseInt(input) && Integer.parseInt(input) <= lastInterval)) {
					System.out.println("Incorrect option input! Please reenter another option input: ");
					input = scanner.nextLine();
					while (!(isNumber(input))) {
						 try {
					        	
					            Integer.parseInt(input);
					            
					        } catch (NumberFormatException e) {
					        	System.out.println("Incorrect option input! Please reenter another option input: ");
					        	input = scanner.nextLine();
			            
					        } 			
					}
    	
			        }
				}
		
			}
		return input;
	}
 
	 private boolean isNumber(String input) {
	    	try {
	            Integer.parseInt(input);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        } 
	    }
	 
	 private boolean isValidCity(String city) {
	        
	        for (String validCity : cityNamesList()) {
	            if (validCity.equalsIgnoreCase(city)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 private boolean isValidCountry(String country) {
	        
	        for (String validCountry : countryNamesList()) {
	            if (validCountry.equalsIgnoreCase(country)) {
	                return true;
	            }
	        }
	        return false;
	    }

}
