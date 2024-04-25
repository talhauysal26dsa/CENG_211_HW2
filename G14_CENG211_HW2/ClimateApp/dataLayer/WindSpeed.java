package dataLayer;

public class WindSpeed extends ClimateMeasurement{
	
	private double metersPerSecond;
	private double kiloMetersPerSecond;
	
	public WindSpeed(int year, int month, double metersPerSecond, double kiloMetersPerSecond) {
		super(year, month);
		this.metersPerSecond = metersPerSecond;
		this.kiloMetersPerSecond = kiloMetersPerSecond;
	}
	
	//Accessor methods
	public double getMetersPerSecond() {
		return metersPerSecond;
	}
	public void setMetersPerSecond(double metersPerSecond) {
		this.metersPerSecond = metersPerSecond;
	}
	
	public double getKiloMetersPerSecond() {
		return kiloMetersPerSecond;
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
			WindSpeed otherWindSpeed = (WindSpeed) otherObject;
			return (this.metersPerSecond == otherWindSpeed.getMetersPerSecond());
		}	
	}
	
	@Override
	public String toString() {
		return (metersPerSecond + " mps");
	}

}
