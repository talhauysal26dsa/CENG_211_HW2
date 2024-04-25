package dataLayer;

public class Temperature extends ClimateMeasurement{
	private double celciusMeasurement;
	private double fahrenheitMeasurement;
	private double kelvinMeasurement;
	
	public Temperature(int year, int month, double celciusMeasurement, double fahrenheitMeasurement, double kelvinMeasurement) {
		super(year, month);
		this.celciusMeasurement = celciusMeasurement;
		this.fahrenheitMeasurement = fahrenheitMeasurement;
		this.kelvinMeasurement = kelvinMeasurement;	
	}
	
	//Accessor methods
	public double getCelciusMeasurement() {
		return celciusMeasurement;
	}
	
	public void setCelciusMeasurement(double celciusMeasurement) {
		this.celciusMeasurement= celciusMeasurement;
		this.fahrenheitMeasurement = celciusToFahrenheit(celciusMeasurement);
		this.kelvinMeasurement = celciusToKelvin(celciusMeasurement);
	}	
	
	public double getFahrenheitMeasurement() {
		return fahrenheitMeasurement;		
	}
	
	
	public double getKelvinMeasurement() {
		return kelvinMeasurement;
	}
	
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
			Temperature otherTemperature = (Temperature) otherObject;
			return (this.celciusMeasurement == otherTemperature.getCelciusMeasurement());
		}	
	}
	
	@Override
	public String toString() {
		return (celciusMeasurement + " Celcius degree");
	}
	 // Method for converting celcius measurement to fahrenheit measurement
    private double celciusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32;
    }

    // Method for converting celcius measurement to kelvin measurement
    private double celciusToKelvin(double celcius) {
        return celcius + 273.15;
    }
}
