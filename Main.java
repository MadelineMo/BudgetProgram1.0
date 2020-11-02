
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	//PREPARE
		Scanner keyboard = new Scanner (System.in); // Declare Scanner
	// Declare variables used to collect basis data in the person while loop
		String repeat;
		String fName;
		String lName;
		String name;
		int userInt;
	// Declare variables for the savings loop	
		Savings s1;
		Savings s2;
		Savings s3;
		Savings s4;
		Savings s5;
		Savings s6;
		Savings sTemp;
		int years;
		int months;
		double income;
		double expenses;
		double extra;
		double perMonth;
		double bankBalence;
		double goal;
		int savingsIndex;
	// Declare variables for the IRA loop
		IRA a1;
		IRA a2;
		IRA a3;
		IRA a4;
		IRA a5;
		IRA a6; 
		double rate;
		double initial;
		int IRAIndex;
	// Declare variables for the two registrys, rs = savings registry, ra = IRA registry
		Registry rs;
		Registry ra;
	// Initialize variables 
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		s5 = null;
		s6 = null;
		sTemp = null;
		a1 = null;
		a2 = null;
		a3 = null;
		a4 = null;
		a5 = null;
		a6 = null;
		rs = new Registry(6); // Registrys max out at 6, hence the 6 savings classes and IRA classes
		ra = new Registry(6);
		
		repeat = "person"; // repeat = "person" so that the user must enter information necessary to compute savings or IRA
		fName = null;
		lName = null;
		name = null;
		userInt =0;
		years = 0;
		months = 0;
		income = 0;
		expenses = 0;
		extra = 0;
		perMonth = 0;
		bankBalence = 0;
		goal = 0;
		rate = 0;
		initial = 0;
		savingsIndex = 1;
		IRAIndex = 1;
	// initial message so the user understands the purpose of the program
		System.out.println("Hello user! This program will help you and others save time and money. \r\n" + 
				"This program can help you project how much you might save using a savings account \r\n" + 
				"or IRA account. But first, some data:");
	//INPUT
		while (!(repeat.equalsIgnoreCase("end"))) { // 'end' while loop so the program will not end until the user asks it too
			
			while (repeat.equalsIgnoreCase("person")) { // First loop to collect initial data to inform later decisions
				System.out.println("What is the first name the account will be under?"); // collect first name for account
				fName = keyboard.next();
				System.out.println("What is the last name the account will be under?"); // collect last name for account
				lName = keyboard.next();
				name = (fName+" "+lName); // save as one name for convenience 
				System.out.println("About how much income do they receive per month on avrege?"); // collect average income per month (everything is computed in months)
				income = keyboard.nextDouble();
				System.out.println("What is the total value of their yearly expenses?"); // collect yearly expenses
				expenses = keyboard.nextDouble()/12; // convert to months (everything is computed to months) and store in singular variable
				System.out.println("What is the total value of their monthly expenses?"); // collect monthly expenses 
				expenses = expenses + keyboard.nextDouble(); // save into same value as 'yearly expenses' - now converted to monthly 
				System.out.println("How much they already have saved up?"); // collect the amount already saved if any (could be useful for either account but necessary for IRA account)
				bankBalence = keyboard.nextDouble();
				
				income = (double)(Math.round(income*100))/100; // income saved with two decimal places to simulate common currency 
				expenses = (double)(Math.round(expenses*100))/100; // expenses saved with two decimal places to simulate common currency 
				extra = income - expenses; // calculate the amount the user has at their disposable per month that could serve to be saved
				System.out.println("The information going forward is: \r\n /Name: "+name+" /Monthly left over income: "+extra+" /Saved: "+bankBalence+"\r\n \r\n");
					// let the user know what information is being used to give them the opportunity to change it if it is incorrect 
				repeat = "no"; // repeat == 'no' so that loops are not triggered and the user is sent to the bottom of the program where they can choose the next program
			}
		//PROCESS
			while (repeat.equalsIgnoreCase("Savings")) { // if the user types 'savings' this loop triggers
				
				if (rs.registryFull()==false) { // so long as the six registry slots arn't full 
					if (savingsIndex == 1) { // savingsIndex used to keep track of the empty slots 
						s1 = new Savings(name , bankBalence, rs); 
						// creates new savings account that stores the account name, amount currently saved, and registry
						sTemp = s1; // saves the called Savings into an easy access variable
					}else if (savingsIndex == 2) {				// repeat for six Savings variables 
						s2 = new Savings(name , bankBalence, rs);
						sTemp = s2;
					}else if (savingsIndex == 3) {
						s3 = new Savings(name , bankBalence, rs);
						sTemp = s3;
					}else if (savingsIndex == 4) {
						s4 = new Savings(name , bankBalence, rs);
						sTemp = s4;
					}else if (savingsIndex == 5) {
						s5 = new Savings(name , bankBalence, rs);
						sTemp = s5; 
					}else if (savingsIndex == 6) {
						s6 = new Savings(name , bankBalence, rs);
						sTemp = s6;
					} savingsIndex++; // next use of the savings loop if not full will register with the next open line 
					System.out.println("Do you want to see how much you can save over time or do you have a goal? (type 'time' or 'goal')"); 
					repeat = keyboard.next(); // user pick to save over time or towards a goal
					if (repeat.equalsIgnoreCase("time")) { // save over time
						System.out.println("Over a period of how many year(s) do you want to save?"); // save how many years they want to save
						years = keyboard.nextInt();
						System.out.println("And how many month(s)?"); // save how many months they want to save 
						months = keyboard.nextInt();
						System.out.println("How much would you like to put away each month? You have "+extra+" extranious income per month");
						perMonth = keyboard.nextDouble(); // save how much they would like to save of their expendable income
						while (perMonth>extra) { // if the amount they wish to save is greater than their expendable income 
							System.out.println("You need to enter a number less than "+extra+", try again:");
							perMonth = keyboard.nextDouble(); // allow the user to enter a valid number rather than start over
							// while loop will continue until they enter a valid number
						}
						System.out.println("Over the corse of "+years+" years and "+months+" months, you would save: "+sTemp.saveOverTime(years, months, perMonth));
						// print out the amount saved by calling the saveOverTime method from the Savings class
					}else if (repeat.equalsIgnoreCase("goal")) { // save to a goal
						System.out.println("How much do you want to save total?"); // save the goal to reach
						goal = keyboard.nextInt();
						System.out.println("How much would you like to put away each month? You have "+extra+" extranious income per month");
						perMonth = keyboard.nextDouble(); // save how much they would like to save of their expendable income
						while (perMonth>extra) { // if the amount they wish to save is greater than their expendable income
							System.out.println("You need to enter a number less than "+extra+", try again:");
							perMonth = keyboard.nextDouble(); // allow the user to enter a valid number rather than starting over
							// while loop will continue until they enter a valid number 
						}
						System.out.println("Over the course of "+(s1.saveToGoal(goal, perMonth))+" you will save "+(sTemp.saveGoal()));
						// print out the amount saved by calling saveToGoal and saveGoal methods from the Savings class 
					}
					repeat = "no"; // repeat == 'no' so that loops are not triggered and the user is sent to the bottom of the program where they can choose the next program
				} else {
					System.out.println(rs); // print the savings registry
					System.out.println("The registry is full, what Savings example do you want to repalce? Type the integer next to the account");
					userInt = keyboard.nextInt(); // allow the user to select which account to retry
					if (userInt == 1) {
						s1.removeAccount(); // call removeAccount method from the Savings class to delete the information saved
						savingsIndex = 1; // when the program repeats it will automatically fill s1 
					} else if(userInt == 2) { // repeat for all six Savings variables
						s2.removeAccount();
						savingsIndex = 2;
					}else if(userInt == 3) {
						s3.removeAccount();
						savingsIndex = 3;
					}else if(userInt == 4) {
						s4.removeAccount();
						savingsIndex = 4;
					}else if(userInt == 5) {
						s5.removeAccount();
						savingsIndex = 5;
					}else if(userInt == 6) {
						s6.removeAccount();
						savingsIndex = 6;
					} else {
						System.out.println("You did not type a number 1-6: INVALID"); // wont compute a wrong answer and will repeat while loop 
					}
					repeat = "savings"; // repeat = 'savings' to fill the now empty slot in the registry 
				}
				System.out.println(rs); // print the registry whether it now has a new slot or an empty one for comparison 
			}
			
			while (repeat.equalsIgnoreCase("IRA")) { // if the user types 'ira' this loop triggers 
				
				if (ra.registryFull()==false) { // so long as the six registry slots arn't full
					System.out.println("Look up potential offers for IRA rates and monthly plans. \r\n What is the APY rate of the plan you wish to test out? ex: 1.55");
					rate = keyboard.nextDouble(); // collect APY rate
					System.out.println("What is the period of months for this plan?");
					months = keyboard.nextInt(); // collect time period for plan (everything is computed in months)
					System.out.println("How much do you want to put away initialy? You currently have "+bankBalence+" saved up");
					initial = keyboard.nextDouble(); // collect how much they would like to deposit of their saved amount
					while (initial>bankBalence) { // if the amount they wish to store is greater than they amount they have saved 
						System.out.println("You need to enter a number less than "+bankBalence+", try again:");
						initial = keyboard.nextDouble(); // allow the user to enter a valid number rather than start over
						// while loop will continue until they enter a valid number
					}
					System.out.println("How much do you want to put away per month on this plan? You have "+extra+" extranious income per month");
					perMonth = keyboard.nextDouble(); // collect how much they would like to save of their expendable income
					while (perMonth>extra) { // if the amount they wish to save is greater than their expendable income
						System.out.println("You need to enter a number less than "+extra+", try again:");
						perMonth = keyboard.nextDouble(); // allow the user to enter a valid number rather than start over
						// while loop will continue until they enter a valid number
					}
					System.out.println("How often does the fund compound intrest? Type 'Daily' 'Weekly' 'Monthly' 'Quarter' 'Semi' or 'Yearly'");
					repeat = keyboard.next(); // save the rate at which the account compounds - repeat is an available variable to be used internally
					while(!(repeat.equalsIgnoreCase("daily")||repeat.equalsIgnoreCase("weekly")||repeat.equalsIgnoreCase("monthly")||repeat.equalsIgnoreCase("quarter")||
							repeat.equalsIgnoreCase("semi")||repeat.equalsIgnoreCase("yearly"))) { // if not a valid input
						System.out.println("You failed to type 'Daily' 'Weekly' 'Monthly' 'Quarter' 'Semi' or 'Yearly' Try again:");
						repeat = keyboard.next(); // allow the user to ender a valid response rather than start over
						// while loop will continue until they enter a valid response 
					}
					if (IRAIndex == 1) { // IRAIndex used to keep track of empty slots
						a1 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						// creates new IRA account that stores the the name, APY rate, duration, initial amount, monthly addition, compounding rate, and registry
						System.out.println(a1.calculateIRA()); // prints the calculated IRA including final amount
					}else if (IRAIndex == 2) { 		// repeat for all 6 IRA variables
						a2 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						System.out.println(a2.calculateIRA());
					}else if (IRAIndex == 3) {
						a3 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						System.out.println(a3.calculateIRA());
					}else if (IRAIndex == 4) {
						a4 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						System.out.println(a4.calculateIRA());
					}else if (IRAIndex == 5) {
						a5 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						System.out.println(a5.calculateIRA());
					}else if (IRAIndex == 6) {
						a6 = new IRA(name, rate, months, initial, perMonth, repeat, ra);
						System.out.println(a6.calculateIRA());
					} 
					IRAIndex++; // next use of the IRA loop if not full will register with the next open line
					repeat = "no"; // repeat == 'no' so that loops are not triggered and the user is sent to the bottom of the program where they can choose the next program
				} else {
					System.out.println(ra); // print the IRA registry
					System.out.println("The registry is full, what IRA example do you want to repalce? Type the Intiger next to the account");
					userInt = keyboard.nextInt(); // allow the user to select which account to retry
					if (userInt == 1) {
						a1.removeAccount(); // call removeAccount method from the IRA class to delete the information saved
						IRAIndex = 1; // when the program repeats it will automatically fill a1
					} else if(userInt == 2) {
						a2.removeAccount();
						IRAIndex = 2;
					}else if(userInt == 3) {
						a3.removeAccount();
						IRAIndex = 3;
					}else if(userInt == 4) {
						a4.removeAccount();
						IRAIndex = 4;
					}else if(userInt == 5) {
						a5.removeAccount();
						IRAIndex = 5; 
					}else if(userInt == 6) {
						a6.removeAccount();
						IRAIndex = 6;
					} else {
						System.out.println("You did not type a number 1-6: INVALID"); // wont compute a wrong answer and will repeat while loop 
					}
					repeat = "IRA"; // repeat = 'IRA' to fill the now empty slot in the registry 
				}
				System.out.println(ra); // print the registry whether it now has a new slot or an empty one for comparison 
			}
			
			
			while (repeat.equalsIgnoreCase("new")) { // if the user wishes to reset their initial information 'new'
				repeat = "person"; // following this loop, the user will be asked to fill in the 'person' loop
				// basis information all reset
				fName = null;
				lName = null;
				name = null;
				bankBalence = 0;
				income = 0;
				expenses = 0;
				perMonth = 0;
				// all other information will be saved like Savings and IRA variables and Registrys in case they wish to compare old data with new data
			}
			System.out.println("Do you want to save using a Savings account, an IRA account, enter new information, or end the program? "
					+ "(type 'Savings' 'IRA' 'new' or 'end' respectvly)"); // asks the user for one of these designated inputs to trigger each while loop
			repeat = keyboard.next();
		}
	}
}
