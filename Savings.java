
/**
 * Write a description of class Savings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Savings {
//PREPARE
	// Declare all necessary variables
	// variables retrieved from user during class declaration
	private Registry registry;
	private String name;
	private double bankBalence;
	// variables calculated or used in other methods
	private double goal;
	private double total;
	private double extra;
	private int time;
	private int index;

//INPUT	
	public Savings() { // blank class declaration
		registry = null;
		name = null;
		bankBalence = 0;
		goal = 0;
		total = 0;
		extra = 0;
		time = 0;
		index = 0;
	}
	
	public Savings(String a, double bank, Registry r) { // informative class declaration method
		registry = r;
		name = a;
		bankBalence = bank;
		goal = 0;
		total = 0;
		extra = 0;
		time = 0;
		index = registry.getNumber(this.toString())-1; // call getNumber from registry to save the placement of this information in the array list
	}
//PROCESS	
	public double saveOverTime (int yr, int mon, double ex) { // calculates the amount saved over time, returns total amount 
		time = yr*12 + mon; // all amounts computed in months
		extra = ex; // save amount to be saved each month
		total = bankBalence; // save initial amount into total
		for (int i=0; i<time; i++) { // for every month in time goal add the extra amount to the total 
			total = total + extra;
		}
		registry.addToRegistry(this.toString()); // save the string format of this savings account information into the savings registry
		return total; // return the total amount saved over time
	}
	
	public String saveToGoal (double go, double ex) { // calculates the time it takes to save to or over the users goal, and returns the time as a string to print
		goal = go; // save amount to achieve
		extra = ex; // save the amount to be saved each month
		total = bankBalence; // save the initial amount into total
		time = 0; // time starts at 0 months 
		while(total<goal) { // until the total is greater or equal to the goal add the extra amount to total and add a month to time
			total = total + extra;
			time++;
		}
		registry.addToRegistry(this.toString()); // save the string format of this savings account information into the savings registry
		return this.timeToString(time); // return the time it takes to save at or above the goal as a string using the timeToString savings method
	}
	
	public double saveGoal () { // called in main and used in conjunction with the saveToGoal method, returns the actual total computed in saveToGoal 
		total = (double)(Math.round(total*100))/100;
		return total;
	}
	
	public String timeToString (int months) { // called in saveOverTime, returns time as a string in order to represent both years and months to the user
		String temp;
		temp = ((months/12)+" years and "+(months%12)+" months");
		return temp;
	}
	
	public void removeAccount() { // remove all stored information
		registry.removeFromRegistry(index); // call removeFromRegistry method from savings registry as called by the stored index number
		registry = null;
		name = null;
		bankBalence = 0;
		goal = 0;
		total = 0;
		extra = 0;
		time = 0;
	}
//OUTPUT	
	public String toString() { // printable account and what is saved in registry
		String ret;
		ret = name+"'s account: /Time: "+this.timeToString(time)+" /Initial ammount: "+bankBalence+" /Monthly contrabution: "+extra+" /Total: "+total;
		return ret;
	}
}
