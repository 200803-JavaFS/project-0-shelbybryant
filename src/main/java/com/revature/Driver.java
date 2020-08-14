package com.revature;

import java.util.Scanner;

import com.revature.model.CustomerAccount;

public class Driver {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in); // creates scanner object
		
		System.out.println(scan);
		
		System.out.println("Hello! Welcome to the Pawnee Bank!");
		
		
		System.out.println("1. New Customer");
		
		String userAnswer = scan.nextLine(); // read user input
		System.out.println(userAnswer);
		
		switch (userAnswer) {
			case "1":
//				createCustomer();
				runCustomerMenu();
				break;
			case "2":
				
///				loginCustomer();
				
			default:
				break;
			
		}
		
		
		
		scan.close();

	}
	
//	public static boolean createCustomer() {
//		
//		
//		
//		return true;
//		
//	}
	
	public static void runCustomerMenu() {
		//pull info from database
		//store info in a customer account instance
		
		
		
		Scanner menu = new Scanner(System.in);
		String menuChoice;
		boolean quit = false;
		do {
			System.out.println("A. Deposit money");
			System.out.println("B. Withdraw money");
			System.out.println("C. Check balance");
			System.out.println("D. Quit system");
			
			menuChoice = menu.nextLine();
			
			switch (menuChoice) {
			case "A":
				double amount;
				System.out.print("What is the amount for your deposit?: ");
				amount = menu.nextDouble();
				//custacc.deposit(amount);
				
				if (amount <= 0.0)
					System.out.println("You cannot depoist a nonpositive amount.");
				else
					System.out.println("$" + amount + " has been deposited.");

				//Direct user to new menu
				runCustomerMenu();
				break;
			case "B":
				System.out.print("What is the amount for your withdrawl?: ");
				amount = menu.nextDouble();
				//custacc.withdraw(amount);
				
				if (amount <= 0.0)
					System.out.println("Withdrawal cannot be completed. Check your balance please to confirm sufficient funds for this withdrawal request.");
				else 
					System.out.println("$" + amount + " has been withdrawn.");
				
				runCustomerMenu();
				break;
				
			case "C":
				//System.out.println("Your balance is: $" + custacc.getBalance());
				
				runCustomerMenu();
				break;
				
			case "D":
				quit = true;
				break;
				
			default:
				System.out.println("The choice you made is not an option.");
				runCustomerMenu();
				break;			
			}
			System.out.println();
			
		} while (!quit);
		System.out.println("Thank you for your patronage!");
		
	}

	
	
	
	
	
	
	
	
}
