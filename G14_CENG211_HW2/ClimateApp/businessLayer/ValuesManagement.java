package businessLayer;

import java.util.Random;



public class ValuesManagement {
	public ValuesManagement(){
		
	}
    static Random random = new Random();

    // Method for generating random number for celcius measurement
    public double getRandomCelciusMeasurement() {
        double min = -40.0;
        double max = 50.0;
        return min + (max - min) * random.nextDouble();
    }

    // Method for converting celcius measurement to fahrenheit measurement
    public double celciusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32;
    }

    // Method for converting celcius measurement to kelvin measurement
    public double celciusToKelvin(double celcius) {
        return celcius + 273.15;
    }

    // Method for generating random number for meter per second
    public double getRandomMetersPerSecond() {
        double min = 0.0;
        double max = 113.2;
        return min + (max - min) * random.nextDouble();
    }

    // Method for converting meter per second to kilometer per second
    public double metersPerSecondToKmph(double metersPerSecond) {
        return metersPerSecond * 3.6;
    }

    // Method for generating random number for humidity percentage
    public double getRandomHumidityPercentage() {
        double min = 0.0;
        double max = 100.0;
        return min + (max - min) * random.nextDouble();
    }

    // Method for generating random number for unit absorption value
    public double getRandomUnitAbsorptionValue() {
        double min = 5.0;
        double max = 20.0;
        return min + (max - min) * random.nextDouble();
    }

    
    

 
}

