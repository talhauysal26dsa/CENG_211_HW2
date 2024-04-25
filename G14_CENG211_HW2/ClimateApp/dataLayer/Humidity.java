package dataLayer;

public class Humidity extends ClimateMeasurement {
	private double humidityPercentage;

	public Humidity(int year, int month, double humidityPercentage) {
		super(year, month);
		this.humidityPercentage = humidityPercentage;
	}

	//Accessor method for humidity percentage
	public double getHumidityPercentage() {
		return humidityPercentage;
	}
	public void setHumidityPercentage(double humidityPercentage) {
		this.humidityPercentage = humidityPercentage;
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
			Humidity otherHumidity = (Humidity) otherObject;
			return (this.humidityPercentage == otherHumidity.humidityPercentage);
		}	
	}
	
	@Override
	public String toString() {
		return (humidityPercentage + "");
	}
	

}