
/**
 * Write a description of class OGBankBudget here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class OGBankBudget
{
    public static void main(String[] args) {
		//PREPARE
		// print: Hello user! This program will help you save time and money. 
			// \n By typing how much money you want to save, your bank balance, you income, 
			// \n and your expenses this program will tell you how long it will take you to save up. 
		// declare scanner and keyboard
		// declare double variables totalSave, bankBalence, income, expenses, perMonth  
		// declare string variable user
		// declare int variables years, numberOfExpenses, and i
		// declare boolean variable repeatProgram
		//INPUT
		//-do {
		// ask the user for how much they would like to save, put input into totalSave 
		// ask the user for their current bank balance or how much they have already saved, initialize into bankBalence 
		// ask the user how many yearly expenses they have, initialize to numberOfExpenses
		// for (i = 0; 0<numberOfExpences; i++) {
			// ask the user for a yearly expense, initialize or add to expenses
		// ask the user how many monthly expenses they have, initialize to numberOfExpenses
				// for (i = 0; 0<numberOfExpences; i++) {
					// ask the user for a monthly expense, *12 and add to expenses
		//PROCESS
		// if expenses >= income 
			// print: if you wish to save money you will need to lover your general expenses 
		//else{
			// while (totalSave > bankBalence) {
				// bankBalence == bankBalence + income - expenses;
				// year = year +1; } 
			// perMonth = (income - expenses)/12
		// }
		//OUTPUT
		// print: "in "+year+" years, you will be able to save "+bankBalence+" if you put away "+perMonth+" per month"
		// would you like to calculate another amount? input user 
		// if user.equalsIgnoreCase("yes") {repeatProgram=true;}
		// else {repeatProgram=false;}
		//REPEAT
		//-}while (repeatProgram=true);
		Scanner keyboard = new Scanner (System.in);
		double totalSave;
		double bankBalence;
		double income;
		double expenses;
		double perMonth;
		String user;
		int years;
		int numberOfExpenses;
		int i;
		boolean repeatProgram;
		System.out.println("Hello user! This program will help you save time and money. \r\n" + 
				"By typing how much money you want to save, your bank balance, you income, \r\n" + 
				"and your expenses this program will tell you how long it will take you to save up.");
		do {
			expenses = 0;
			years = 0;
			System.out.println("How much would you like to save?");
			totalSave = keyboard.nextDouble();
			if (totalSave == 0) {
				System.out.println("This program is not for you");
			} else {
				System.out.println("How much do you currently have saved?");
				bankBalence = keyboard.nextDouble();
				if (totalSave<=bankBalence) {
					System.out.println("You have already saved up "+totalSave+", your bank contains "+bankBalence);
				} else {
					System.out.println("About how much income do you receive per month?");
					income = keyboard.nextDouble();
					income = income*12;
					System.out.println("How many yearly expences do you typicaly have?");
					numberOfExpenses = keyboard.nextInt();
					for (i=0; i < numberOfExpenses; i++) {
						System.out.println("What is one of your yearly expences?");
						expenses = expenses + keyboard.nextDouble();
					}
					System.out.println("How many monthly expences do you typicaly have?");
					numberOfExpenses = keyboard.nextInt();
					for (i=0; i < numberOfExpenses; i++) {
						System.out.println("What is one of your monthly expences?");
						expenses = expenses + 12*keyboard.nextDouble();
					}
					if (income <= expenses) {
						System.out.println("Possibly you enterd your numbers incorectly, but as it stands your expenses "+expenses+" outway your income "+
							income+"\nthus you are unable to save money");
					}else{
						while (totalSave > bankBalence) {
							bankBalence = bankBalence + income - expenses;
							years = years +1; 
							} 
						bankBalence = (double)(Math.round(bankBalence*100))/100;
						perMonth = (income - expenses)/12;
						System.out.println("Within "+years+" year(s) you will be able to save "+bankBalence+" if you put away "+perMonth+" per month");
					}
				}
			}
			System.out.println("Would you like to repeat the program?");
			keyboard.nextLine();
			user = keyboard.nextLine();
			if (user.equalsIgnoreCase("yes")) {
				repeatProgram = true;
			} else {repeatProgram = false;}
		} while (repeatProgram);
	
	}
}
