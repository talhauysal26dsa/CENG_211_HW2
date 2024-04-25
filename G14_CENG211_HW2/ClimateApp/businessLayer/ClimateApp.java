package businessLayer;

import java.util.ArrayList;

import dataLayer.City;
import dataLayer.ClimateMeasurement;
import dataLayer.Country;
import dataLayer.Humidity;
import dataLayer.RadiationAbsorption;

import dataLayer.Temperature;
import dataLayer.WindSpeed;

public class ClimateApp {
	private ClimateRecords climateRecords = new ClimateRecords();
	
	public ClimateApp() {
		
	}
	
	//Method for first query calculations
	public  double getAverageTemperatureForACountry(String selectedCountry ,int selectedMeasurementChoice, int selectedYear) {
		double sum = 0;
		for (Country country: climateRecords.getArrayListOfCountry()) {			
			if (country.getName().equals(selectedCountry)) {			
				if(selectedYear==1) {						
					for (Temperature temperature : country.getCountryWideAverageTemperatureList()) {						
						if (temperature.getYear()==2020) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {					
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}					
						}				
					}					
				}
				else if(selectedYear==2) {		
					for (Temperature temperature : country.getCountryWideAverageTemperatureList()) {
						if (temperature.getYear()==2021) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}									
						}			
					}				
				}
				else if(selectedYear==3) {
					for (Temperature temperature : country.getCountryWideAverageTemperatureList()) {
						if (temperature.getYear()==2022) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}	
						}	
					}				
				}
			}
		}
		return sum/12;
	}
	
	//Method for second query calculations
	public double getAverageTemperatureForaCity(String selectedCity ,int selectedMeasurementChoice, int selectedYear) {
		double sum = 0;
		for (City city: climateRecords.getArrayListOfCity()) {						
			if (city.getName().equals(selectedCity)) {				
				if(selectedYear==1) {						
					for (Temperature temperature : createArrayListOfTemperature(city.getClimateMeasurementArrayList())) {						
						if (temperature.getYear()==2020) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {					
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}						
						}				
					}					
				}
				else if(selectedYear==2) {						
					for (Temperature temperature : createArrayListOfTemperature(city.getClimateMeasurementArrayList())) {
						if (temperature.getYear()==2021) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}									
						}			
					}				
				}
				else if(selectedYear==3) {						
					for (Temperature temperature : createArrayListOfTemperature(city.getClimateMeasurementArrayList())) {
						if (temperature.getYear()==2022) {
							if(selectedMeasurementChoice==1) {
								sum += temperature.getCelciusMeasurement();					
							}
							else if(selectedMeasurementChoice==2) {
								sum += temperature.getFahrenheitMeasurement();
							}
							else if(selectedMeasurementChoice==3) {
								sum += temperature.getKelvinMeasurement();
							}							
						}	
					}					
				}
			}	
		}
		return sum/12;
	}
	
	//Method for third query calculations
	public double averageWindSpeed(String selectedCity, int selectedUnitOfSpeed, int selectedMonth){//selectedYears eklemeli miyiz!!??
        double total = 0;
        for (City city : climateRecords.getArrayListOfCity()) {
            if (city.getName().equals(selectedCity)) {
            	
                for (WindSpeed windSpeed : createArrayListOfWindSpeed(city.getClimateMeasurementArrayList()))//citymizin ilk ayının 2. ayının 3. ayının .... windSpeedi

                    if (windSpeed.getMonth() == selectedMonth) {
                        if (selectedUnitOfSpeed==1) {//if selected unit is km/s:
                        		
                            total += windSpeed.getKiloMetersPerSecond();
                    }
                        else if(selectedUnitOfSpeed==2) {//if selected unit is mp/s:
                            total += windSpeed.getMetersPerSecond();
                        }
                }
            }
        }
        return total/3;
    }
	
	//Method for fourth query calculations
	public double getAverageHumidity(String selectedCity) {
		double sum = 0;
		for (City city : climateRecords.getArrayListOfCity()) {
			if (city.getName().equals(selectedCity)) {
				for(Humidity humidity : createArrayListOfHumidity(city.getClimateMeasurementArrayList())) {
					sum += humidity.getHumidityPercentage();
				}				
			}			
		}
		return sum/36;	
	}
	
	//Method for fifth query calculations
	public int findRadiationIntensity(String selectedCity, String selectedValue, int selectedYear) {
        int count =0;
		for (City city : climateRecords.getArrayListOfCity()) {      
        	if (city.getName().equals(selectedCity)) {            	
            	if(selectedYear==1) {           		
            		for(RadiationAbsorption radiationAbsorption : createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList())) {            			
            			if((radiationAbsorption.getYear()==2020)) {           				
            				if(radiationAbsorption.getIntensity().name().equals(selectedValue)) {
            					count++;           					
            				}	
            			}           			        
                    }           		
            	}
            	else if(selectedYear ==2) {
            		for(RadiationAbsorption radiationAbsorption : createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList())) {           			
            			if((radiationAbsorption.getYear()==2021)) {            				
            				if(radiationAbsorption.getIntensity().name().equals(selectedValue)) {
            					count++;           					
            				}		
            			}     
                    }		
            	}
            	else if(selectedYear ==3) {
            		for(RadiationAbsorption radiationAbsorption : createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList())) {            			
            			if((radiationAbsorption.getYear()==2022)) {            				
            				if(radiationAbsorption.getIntensity().name().equals(selectedValue)) {
            					count++;            					
            				}	
            			}
                    }            		
            	}     
            }
        }
		return count;
    }	
	
	//Method for sixth query calculations
	public double getFeltTemperatureForYearAndMonthForCity(String selectedCity, int selectedYear, int selectedMonth) {
		double calculatedFeltTemperature =0;
        for (City city : climateRecords.getArrayListOfCity()) {
            if (city.getName().equals(selectedCity)) {
            	
            	if (selectedYear==1) {//if 2020
            		Temperature temperatureOfCity = createArrayListOfTemperature(city.getClimateMeasurementArrayList()).get(selectedMonth-1);
            		WindSpeed windSpeedOfCity = createArrayListOfWindSpeed(city.getClimateMeasurementArrayList()).get(selectedMonth-1);
            		Humidity humidityOfCity = createArrayListOfHumidity(city.getClimateMeasurementArrayList()).get(selectedMonth-1);
            		RadiationAbsorption radiationAbsorptionOfCity = createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList()).get(selectedMonth-1);
            		calculatedFeltTemperature = calculateFeltTemperature(temperatureOfCity.getCelciusMeasurement(), humidityOfCity.getHumidityPercentage()
           				 , windSpeedOfCity.getMetersPerSecond(), radiationAbsorptionOfCity.getUnitAbsorptionValue());           		
                }
            	else if (selectedYear==2) {//if 2021
            		Temperature temperatureOfCity = createArrayListOfTemperature(city.getClimateMeasurementArrayList()).get(selectedMonth+11);//our 12. index is first month of second(2021) year
            		WindSpeed windSpeedOfCity = createArrayListOfWindSpeed(city.getClimateMeasurementArrayList()).get(selectedMonth+11);
            		Humidity humidityOfCity = createArrayListOfHumidity(city.getClimateMeasurementArrayList()).get(selectedMonth+11);
            		RadiationAbsorption radiationAbsorptionOfCity = createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList()).get(selectedMonth+11);
            		calculatedFeltTemperature = calculateFeltTemperature(temperatureOfCity.getCelciusMeasurement(), humidityOfCity.getHumidityPercentage()
              				 , windSpeedOfCity.getMetersPerSecond(), radiationAbsorptionOfCity.getUnitAbsorptionValue());
                }
            	else if (selectedYear==3) {//if 2022
            		Temperature temperatureOfCity = createArrayListOfTemperature(city.getClimateMeasurementArrayList()).get(selectedMonth+23);//our 23. index is first month of third(2022) year
            		WindSpeed windSpeedOfCity = createArrayListOfWindSpeed(city.getClimateMeasurementArrayList()).get(selectedMonth+23);
            		Humidity humidityOfCity = createArrayListOfHumidity(city.getClimateMeasurementArrayList()).get(selectedMonth+23);
            		RadiationAbsorption radiationAbsorptionOfCity = createArrayListOfRadiationAbsorption(city.getClimateMeasurementArrayList()).get(selectedMonth+23);
            		calculatedFeltTemperature = calculateFeltTemperature(temperatureOfCity.getCelciusMeasurement(), humidityOfCity.getHumidityPercentage()
              				 , windSpeedOfCity.getMetersPerSecond(), radiationAbsorptionOfCity.getUnitAbsorptionValue());
                }
            }
        }
		return calculatedFeltTemperature;
    }
	
	
	 private ArrayList<Temperature> createArrayListOfTemperature(ArrayList<ClimateMeasurement>climateMeasurementArrayList) {
			ArrayList<Temperature> temperatureArrayList = new ArrayList<Temperature>();
			
			for (ClimateMeasurement climateMeasurement : climateMeasurementArrayList) {			
				if (climateMeasurement instanceof Temperature){
					temperatureArrayList.add((Temperature)climateMeasurement);	
				}
				
				
			}
			
			return temperatureArrayList;		
		}
	 private ArrayList<WindSpeed> createArrayListOfWindSpeed(ArrayList<ClimateMeasurement>climateMeasurementArrayList) {
			ArrayList<WindSpeed> windSpeedArrayList = new ArrayList<WindSpeed>();
			
			for (ClimateMeasurement climateMeasurement : climateMeasurementArrayList) {			
				if (climateMeasurement instanceof WindSpeed){
					windSpeedArrayList.add((WindSpeed)climateMeasurement);	
				}
				
				
			}
			
			return windSpeedArrayList;		
		}
	 private ArrayList<Humidity> createArrayListOfHumidity(ArrayList<ClimateMeasurement>climateMeasurementArrayList) {
			ArrayList<Humidity> humidityArrayList = new ArrayList<Humidity>();
			
			for (ClimateMeasurement climateMeasurement : climateMeasurementArrayList) {			
				if (climateMeasurement instanceof Humidity){
					humidityArrayList.add((Humidity)climateMeasurement);	
				}
				
				
			}
			return humidityArrayList;		
		}
	 private ArrayList<RadiationAbsorption> createArrayListOfRadiationAbsorption(ArrayList<ClimateMeasurement>climateMeasurementArrayList) {
			ArrayList<RadiationAbsorption> radiationAbsorptionArrayList = new ArrayList<RadiationAbsorption>();
			
			for (ClimateMeasurement climateMeasurement : climateMeasurementArrayList) {			
				if (climateMeasurement instanceof RadiationAbsorption){
					radiationAbsorptionArrayList.add((RadiationAbsorption)climateMeasurement);	
				}
				
				
			}return radiationAbsorptionArrayList;
			
						
}
	 private double calculateFeltTemperature(double cityTemperature, double humidity, double windSpeed, double radiationAbsorption) {
	        return cityTemperature + (0.3 * (humidity / 100)) - (0.7 * (radiationAbsorption / (windSpeed + 10)));
	    }
	 }
	
	
	
	


