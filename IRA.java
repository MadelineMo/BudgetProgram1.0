
/**
 * Write a description of class IRA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IRA {
//PREPARE
	// Declare all necessary variables
	// Variables retrieved from user during class declaration
	private Registry registry;
	private String name;
	private String compoundingString;
	private double APY;
	private double initial;
	private double extra;
	private int months;
	// variables calculated or used in other methods 
	private double total;
	private double anualRate;
	private double time;
	private int compoundingPeriod;
	private int index;
//INPUT
	public IRA() { // blank class declaration
		registry = null;
		name = null;
		compoundingString = null;
		APY = 0;
		initial = 0;
		extra = 0;
		months = 0;
		compoundingPeriod = 0;
		anualRate = 0;
		index = 0;
		total = 0;
		time = 0;
	}
	
	public IRA(String n, double a, int t, double in, double ex, String p, Registry r) { // informative class declaration method
		registry = r;
		name = n;
		compoundingString = p;
		APY = a;
		initial = in;
		extra = ex;
		months = t;
		// call compoundingStringtoInt from this class to convert string to int in terms of compounding interest
		compoundingPeriod = this.compoundingStringToInt(compoundingString); 
		anualRate = this.anualRate(); // call anualRate from this class to convert APY to the yearly interest rate
		index = registry.getNumber(this.toString())-1; // call getNumber from registry to save the placement of this information in the array list
		total = 0;
		time = 0;
	}
//PROCESS
	public int compoundingStringToInt(String c) { // convert inputed string variable from user into an integer representing repetition per year to be used later
		if (compoundingString.equalsIgnoreCase("daily")) {
			compoundingPeriod = 365; // daily means 365 repetitions per year 
		}else if (compoundingString.equalsIgnoreCase("weekly")) {
			compoundingPeriod = 52; // weekly means 52 repetitions per year
		}else if (compoundingString.equalsIgnoreCase("monthly")) {
			compoundingPeriod = 12; // monthly means 12 repetitions per year 
		}else if (compoundingString.equalsIgnoreCase("quarter")) {
			compoundingPeriod = 4; // quarterly means 4 repetitions per year
		}else if (compoundingString.equalsIgnoreCase("semi")) {
			compoundingPeriod = 2; // semi-annually means 2 repetitions per year 
		}else if (compoundingString.equalsIgnoreCase("yearly")) {
			compoundingPeriod = 1; // yearly is only once a year 
		}
		return compoundingPeriod; // returns an integer representing the compounding interests repetitions per year 
	}
	
	public double anualRate() { // converts the APY given by many banks to an annual rate 
		anualRate = ((Math.pow(((APY/100)+1),1/compoundingPeriod)-1)*compoundingPeriod)+1; // +1 so rate ex: 1.05 easyer to compute 
		anualRate = (double)(Math.round(anualRate*100))/100; // converts annual rate into a variable with two decimal places 
		return anualRate; // returns annual rate to be used in computing final amount
	}
	
	public double totalYeildDaily() { // if the compounding rate is daily 
		time = months*(365/12); // (365/12) = average number of days in a month *months variable = total number of days to compound interest 
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 1; i<time; i++) { // for each day of the time period 
			if (i%30 == 0) { // for every 30 days add the monthly amount to be saved from the users extraneous income
				total = total + extra;
			}
			total = total*anualRate; 
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double totalYeildWeek() { // if the compounding rate is weekly
		time = months*(13/3); // (13/3) = average number of weeks in a month *months variable = total number of weeks to compound interest 
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 0; i<time; i++) { // for each week of the time period 
			if (i%4 == 0) { // for every 4 weeks add the monthly amount to be saved from the users extraneous income
				total = total + extra;
			}
			total = total*anualRate;
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double totalYeildMonth() { // if the compounding rate is monthly
		time = months; // monthly interest compounding = months total 
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 0; i<time; i++) { // for each month of the time period
			total = total + extra;
			total = total*anualRate;
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double totalYeildQuart() { // if the compounding rate is quarterly
		time = months/4; // months/4 = number of quarterly repetitions over time period
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 0; i<time; i++) { // for each quarter in the time period 
			total = total + extra*4; // 4 months of contribution
			total = total*anualRate;
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double totalYeildSemi() { // if the compounding rate is semi-annually
		time = months/6; // months/6 = number of half year repetitions over time period 
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 0; i<time; i++) { // for each half year in the time period
			total = total + extra*6; // 6 months of contributions 
			total = total*anualRate;
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double totalYeildYear() { // if the compounding rate is yearly
		time = months/12; // months/12 = number of yearly repetitions over time period
		total = initial; // total starts as the initial amount saved into the account
		for (int i = 0; i<time; i++) { // for each year in the time period 
			total = total + extra*12; // 12 months of contributions 
			total = total*anualRate;
			total = (double)(Math.round(total*100))/100; // save total as a variable with two decimal places each time it is compounded to prevent discrepancy's
		}
		return total;
	}
	
	public double calculateTerminal() { // calculates the IRA account total based on the compounding rate 
		if(compoundingPeriod == 365) { // daily
			total = this.totalYeildDaily(); // saves total using the totalYeildDaily method from this class
		}else if (compoundingPeriod == 52) { // weekly
			total = this.totalYeildWeek(); // saves total using the totalYeildWeek method from this class
		}else if (compoundingPeriod == 12) { // monthly
			total = this.totalYeildMonth(); // saves total using the totalYeildMonth method from this class
		}else if (compoundingPeriod == 4) { // quarterly
			total = this.totalYeildQuart(); // saves total using the totalYeildQuart method from this class 
		}else if (compoundingPeriod == 2) { // semi-annually
			total = this.totalYeildSemi(); // saves total using the totalYeildSemi method from this class
		}else if (compoundingPeriod == 1) { // yearly
			total = this.totalYeildYear(); // saves total using the totalYeildYear method from this class
		}
		return total; // returns total from one of the methods above
	}
	
	public String calculateIRA() { // returns a string for the user including the time and total 
		anualRate = this.anualRate(); // Calculates annual rate from APY
		total = this.calculateTerminal(); // calculates the total using the calculateTerminal method in this class
		String temp;
		temp = "Over the corse of "+months+" months you save a total of "+total+"dollars";
		registry.addToRegistry(this.toString()); // records the string format of this IRA account information into the IRA registry
		return temp;
	}
	
	public void removeAccount() { // remove all stored information
		registry.removeFromRegistry(index); // call removeFromRegistry method from IRA registry as called by the stored index number
		registry = null;
		name = null;
		time = 0;
		APY = 0;
		months = 0;
		initial = 0;
		extra = 0;
		compoundingString = null;
		compoundingPeriod = 0;
		anualRate = 0;
		total = 0;
		index = 0;
	}
//OUTPUT	
	public String toString() { // printable account and what is saved in registry
		String temp;
		temp = "/Name: "+name+" /APY Rate: "+APY+" /Months: "+months+" /Compounded:"+compoundingString+" /Initial amount: "+initial+" /Per month: "+extra+" /Total: "+total;
		return temp;
	}
	
}
