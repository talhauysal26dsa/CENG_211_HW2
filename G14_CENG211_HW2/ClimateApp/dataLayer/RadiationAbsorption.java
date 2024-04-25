package dataLayer;

import java.util.Random;

public class RadiationAbsorption extends ClimateMeasurement{	
	private double unitAbsorptionValue;
	public enum RadiationIntensity{LOW, MEDIUM, HIGH};
	private RadiationIntensity intensity;
	
	public RadiationAbsorption(int year, int month, double unitAbsorptionValue, RadiationIntensity intensity) {
		super(year, month);
		this.intensity = intensity;
		this.unitAbsorptionValue = unitAbsorptionValue;	
	}

	//Accessor methods
	public double getUnitAbsorptionValue() {
		return unitAbsorptionValue;
	}
	public void setUnitAbsorptionValue(double unitAbsorptionValue) {
		this.unitAbsorptionValue=unitAbsorptionValue;
	}

	public RadiationIntensity getIntensity() {
		return intensity;
	}
	
	//Method for generating random radiation intensity level for measurements
	public static RadiationIntensity generateRandomRadiationIntensity() {
		Random random = new Random();
        RadiationIntensity[] intensity = RadiationIntensity.values();
        return intensity[random.nextInt(intensity.length)];
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
			RadiationAbsorption otherRadiationAbsorption = (RadiationAbsorption) otherObject;
			return ((this.unitAbsorptionValue == otherRadiationAbsorption.unitAbsorptionValue)&&this.intensity.equals(otherRadiationAbsorption.getIntensity()));
		}	
	}
	
	@Override
	public String toString() {
		
		return (this.getIntensity().name()+""+unitAbsorptionValue);
	}
}
