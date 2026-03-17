import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) {
		List<InHouseEmployee> inHouseEmployees = new ArrayList<>();
		List<OutsourceEmployee> outsourceEmployees = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2017, Calendar.MAY, 22);
		inHouseEmployees.add(new InHouseEmployee("A17", cal.getTime(), 7.5, 22, 0));
		
		cal.set(2017, Calendar.JUNE, 22);
		inHouseEmployees.add(new InHouseEmployee("A17", cal.getTime(), 7.5, 22, 0));
		
		cal.set(2017, Calendar.JULY, 22);
		inHouseEmployees.add(new InHouseEmployee("A173", cal.getTime(), 120, 220, 1000));
		
		cal.set(2017, Calendar.APRIL, 22);
		inHouseEmployees.add(new InHouseEmployee("A17", cal.getTime(), 7.5, 22, 0));
		
		
		cal.set(2017, Calendar.MAY, 21);
		outsourceEmployees.add(new OutsourceEmployee("A239", cal.getTime(), 8.4, 19, 10));
		
		cal.set(2017, Calendar.JUNE, 21);
		outsourceEmployees.add(new OutsourceEmployee("A239", cal.getTime(), 8.4, 19, 10));
		
		cal.set(2017, Calendar.JULY, 21);
		outsourceEmployees.add(new OutsourceEmployee("A23950", cal.getTime(), 8.4, 1900, 1000));
		
		cal.set(2017, Calendar.APRIL, 21);
		outsourceEmployees.add(new OutsourceEmployee("A239", cal.getTime(), 8.4, 19, 10));
		
		
		System.out.println("Daily Cost for in-house employees");
		printDailyCost(inHouseEmployees);
		
		System.out.println("\n==============================================\n");
		
		System.out.println("Daily Cost for outsoruced employees");
		printDailyCost(outsourceEmployees);
		
		System.out.println("\n==============================================\n");
		
		System.out.println("Ranking for in-house employees");
		printRanking(inHouseEmployees);
		
		System.out.println("\n==============================================\n");
		
		System.out.println("Ranking for outsourced employees");
		printRanking(outsourceEmployees);
		
		System.out.println("\n==============================================\n");
		
	}
	
	public static void printDailyCost(List<? extends Employee> employees) {
		// add total cost per employee
		Map<Date, Double> dailyCost = new TreeMap<>();
		for(Employee e : employees) {
			
			Date date = e.getDate();
			if(dailyCost.containsKey(date)) {
				dailyCost.put(date, dailyCost.get(date) + e.amountOfCost());
			} else {
				dailyCost.put(date, e.amountOfCost());
			}
		}
		
		// print dates and total cost
		for(Date date : dailyCost.keySet()) {
			System.out.println("Date:" + date + ", Cost: " + String.format("%.2f", dailyCost.get(date)));
		}
		
	}
	
	
	public static void printRanking(List<? extends Employee> employees) {
		// sum of cost per employee id
		Map<String, Double> totalByEmployee = new HashMap<>();
		for(Employee e : employees) {
			if(totalByEmployee.containsKey(e.getId())) {
				totalByEmployee.put(e.getId(), totalByEmployee.get(e.getId()) + e.amountOfCost());
			} else {
				totalByEmployee.put(e.getId(), e.amountOfCost());
			}
		}
		
		// sort costs with tree map
		TreeMap<Double, String> sorted = new TreeMap<>(Collections.reverseOrder());
		for(String id : totalByEmployee.keySet()) {
			sorted.put(totalByEmployee.get(id), id);
		}
		
		// print ranking
		int rank = 1;
		for(Double cost : sorted.keySet()) {
			System.out.println("Rank: " + rank++ + ", ID: " + sorted.get(cost) + ", Cost: " + String.format("%.2f", cost));
		}
	}
}
