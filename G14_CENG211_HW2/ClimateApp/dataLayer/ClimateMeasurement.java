package dataLayer;

public class ClimateMeasurement {
	private int year;
	private int month;
	
	//Constructor
	public ClimateMeasurement(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	//Accessor methods
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
			
		
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int Year) {
		this.year = Year; 
		
	}
	
	//Equals methods
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
			ClimateMeasurement otherClimateMeasurement = (ClimateMeasurement) otherObject;
			return (this.month == otherClimateMeasurement.month) && (this.year == otherClimateMeasurement.year);
		}	
	}	

	//ToString method
	@Override
	public String toString() {
		return ""+month;
	}
}
