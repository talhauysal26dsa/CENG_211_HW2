package businessLayer;

import java.util.ArrayList;
import dataLayer.RadiationAbsorption;
import dataLayer.ClimateMeasurement;
import dataLayer.Humidity;
import dataLayer.WindSpeed;
import dataLayer.Temperature;

public class GenerateMeasurements {
	
	
	ValuesManagement valuesManagement = new ValuesManagement();
	
	public GenerateMeasurements() {
		
	}
	
	//Method for generating measurement list for the field of cities 
	public ArrayList<ClimateMeasurement> generateMeasurementList(){
		ArrayList<ClimateMeasurement> climateMeasurementList = new ArrayList<ClimateMeasurement>();
		for(int year= 2020; year<=2022; year++) {
			for(int month =1; month<=12;month++) {
				Humidity humidity = new Humidity(year, month, valuesManagement.getRandomHumidityPercentage());				
				
				RadiationAbsorption radiationAbsorption = new RadiationAbsorption(year, month, valuesManagement.getRandomUnitAbsorptionValue(),RadiationAbsorption.generateRandomRadiationIntensity());	
				
				double metersPerSecond = valuesManagement.getRandomMetersPerSecond();
				WindSpeed windSpeed = new WindSpeed(year, month, metersPerSecond, valuesManagement.metersPerSecondToKmph(metersPerSecond));
				
				double celcius = valuesManagement.getRandomCelciusMeasurement();
				Temperature temperature = new Temperature(year, month, celcius, valuesManagement.celciusToFahrenheit(celcius), valuesManagement.celciusToKelvin(celcius));
				
				climateMeasurementList.add(temperature);
				climateMeasurementList.add(windSpeed);
				climateMeasurementList.add(humidity);
				climateMeasurementList.add(radiationAbsorption);	
			}	
		}
		return climateMeasurementList;		
	}
	
	//Method for generating temperature list for the field of countries
	public ArrayList<Temperature> generateTemperatureForCountry(){
        ArrayList<Temperature> climateMeasurementList = new ArrayList<Temperature>();
        for(int year= 2020; year<=2022; year++) {
            for(int month =1; month<=12;month++) {
                double celcius = valuesManagement.getRandomCelciusMeasurement();
                Temperature temperature = new Temperature(year, month, celcius, valuesManagement.celciusToFahrenheit(celcius), valuesManagement.celciusToKelvin(celcius));
                
                climateMeasurementList.add(temperature);
            }
        }
        return climateMeasurementList;
    }

}
