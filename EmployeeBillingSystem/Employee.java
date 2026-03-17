import java.util.Date;

public class Employee {
	private final String id;
	private final Date date;
	private final double hours;
	private final double hourlyRate;
	private final double fixedCost;
	
	public Employee(String id, Date date, double hours, double hourlyRate, double fixedCost) {
		this.id = id;
		this.date = date;
		this.hours = hours;
		this.hourlyRate = hourlyRate;
		this.fixedCost = fixedCost;
	}
	
	public double amountOfCost() {
		return (hours * hourlyRate) + fixedCost;
	}
	
	public String getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
}
