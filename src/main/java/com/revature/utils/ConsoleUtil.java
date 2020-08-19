package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.AccountService;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;

public class ConsoleUtil {

	private Customer loggedInCustomer;
	private Employee loggedInEmployee;
	private static Scanner scan = new Scanner(System.in);
	private CustomerService cs = new CustomerService();
	private AccountService as = new AccountService();
	private EmployeeService es = new EmployeeService();
	
	public void beginApp() {
		System.out.println("Welcome to the Pawnee Bank! How can we be of service today?");
		System.out.println("[1] I am a returning customer, I would like to login. \n"
				+ "[2] I am a new customer, I would like to create an account. \n"
				+ "[3] I work here, I would like to login for work. \n" 
				+ "[4] Well, I'm ready to leave! Thank you!");
		
		String answer = scan.nextLine();
		answerSwitch(answer);
		
		
	}

	private void answerSwitch(String answer) {
		switch(answer) {
		
		case "1":
			//login as returning customer
			beginLogin();
			break;
		
		case "2":
			//create new customer
			registerCustomer();
			break;
		case "3":
			//employee login
			employeeLogin();
			break;
		case "4":
			//exit
			System.out.println("Thank you for coming in!");
			break;
			
		default:
			System.out.println("you have entered an incorrect value, please try again!");
			beginApp();
			break;
		
		}
		
	}

	private void beginLogin() {
		System.out.println("What is your customer id?");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("What is your password?");
		String password = scan.nextLine();
		
		this.loggedInCustomer = cs.loginCustomer(id, password);
		System.out.println("Ah! We found you!");
		System.out.println("Here is your customer information: " + this.loggedInCustomer);
		
		customerMenu();

	}
	
	private void registerCustomer() {
		System.out.println("What is your first name?");
		String firstName = scan.nextLine();
		System.out.println("what is your last name?");
		String lastName = scan.nextLine();
		System.out.println("Please enter the password you would like saved for this account.");
		String password = scan.nextLine();
		System.out.println("What is your phone number?");
		String phone = scan.nextLine();
		System.out.println("What is your street address?");
		String streetAddress = scan.nextLine();
		System.out.println("What city do you live in?");
		String city = scan.nextLine();
		System.out.println("What state is that city in?");
		String state = scan.nextLine();
		System.out.println("What is the zip code for that area?");
		int zipCode = scan.nextInt();
		
		
		List<Customer> list = cs.findAll();
		
		int id = list.size() + 1;
		
		System.out.println(list.size());
		
		Account account = new Account(id, 0.0,0.0, 0.0, 0.0, false, false);
		Customer customer = new Customer(id, firstName, lastName, password, phone, streetAddress, city, state, zipCode, account);
		
		boolean accountWasAdded = as.addAccount(account);
		boolean customerWasAdded = cs.addCustomer(customer);
		
		beginApp();
	}
	
	private void customerMenu() {
		System.out.println("Welcome to the customer menu! What would you like to do today?");
		System.out.println("[1] Update personal information. \n "
				+ "[2] View account information. \n "
				+ "[3] Make a deposit. \n "
				+ "[4] Make a withdrawal. \n "
				+ "[5] Transfer funds. \n "
				+ "[6] I'm all done, I would like to leave! \n ");
		String menuAnswer = scan.nextLine();
		menuSwitch(menuAnswer);
		
	}

	private void menuSwitch(String menuAnswer) {
		switch(menuAnswer) {
		case "1":
			//update personal info
			updatePersonalInfo();
			break;
		case "2":
			//view account info
			viewAccountInfo();
			break;
		case "3":
			//make a deposit
			makeDeposit();
			break;
		case "4":
			//make a withdrawal
			makeWithdrawal();
			break;
		case "5":
			//transfer funds
			transferFunds();
			break;
		case "6":
			//exit
			System.out.println("Thank you for coming in, have a nice day!");
			break;
		default:
			System.out.println("You have entered an incorrect value, please try again.");
			customerMenu();
			break;

		
		}
		
	}


	private void transferFunds() {
		System.out.println("You want to make a transfer of funds? Coolio!");
		System.out.println("Would you like to make a transfer from your checking account or saving account? [check/save]");
		String tansferAnswer = scan.nextLine();
		
		if (tansferAnswer.toLowerCase().equals("check")) {
			
			Account account = this.loggedInCustomer.getAccount();
			
			System.out.println("What is the amount you would like to remove from your checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
			
			
			if(as.transferFromCheckToSave(account, checkAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again.");
				customerMenu();
			}
			
		} else if (tansferAnswer.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to remove from your saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			Account account = this.loggedInCustomer.getAccount();
			
			if (as.transferFromSaveToCheck(account, saveAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again!");
				customerMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			customerMenu();
		}
		System.out.println("Returning to customer menu.");
		customerMenu();
		
	}

	private void makeWithdrawal() {
		System.out.println("You're here to make a withdrawal? Neat-O!");
		System.out.println("Would you like to make a withdrawl from your checking account or saving account? [check/save]");
		String withdrawalAnswer = scan.nextLine();
		
		if (withdrawalAnswer.toLowerCase().equals("check")) {
			
			Account account = this.loggedInCustomer.getAccount();
			
			System.out.println("What is the amount you would like to remove from your checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
			
			
			if(as.withdrawChecking(account, checkAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again.");
				customerMenu();
			}
			
		} else if (withdrawalAnswer.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to remove from your saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			Account account = this.loggedInCustomer.getAccount();
			
			if (as.withdrawSaving(account, saveAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again!");
				customerMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			customerMenu();
		}
		System.out.println("Returning to customer menu");
		customerMenu();
	}

	private void updatePersonalInfo() {
		System.out.println("You want to change your personal info? Okay!");
		System.out.println("We will go through all the columns and you just add in the info you want added!");
		
		System.out.println("What is your first name?");
		String firstName = scan.nextLine();
		System.out.println("what is your last name?");
		String lastName = scan.nextLine();
		System.out.println("Please enter the password you would like saved for this account.");
		String password = scan.nextLine();
		System.out.println("What is your phone number?");
		String phone = scan.nextLine();
		System.out.println("What is your street address?");
		String streetAddress = scan.nextLine();
		System.out.println("What city do you live in?");
		String city = scan.nextLine();
		System.out.println("What state is that city in?");
		String state = scan.nextLine();
		System.out.println("What is the zip code for that area?");
		int zip = scan.nextInt();
		scan.nextLine();
		
		this.loggedInCustomer.setFirstName(firstName);
		this.loggedInCustomer.setLastName(lastName);
		this.loggedInCustomer.setPassword(password);
		this.loggedInCustomer.setPhone(phone);
		this.loggedInCustomer.setStreetAddress(streetAddress);
		this.loggedInCustomer.setCity(city);
		this.loggedInCustomer.setState(state);
		this.loggedInCustomer.setZip(zip);


		boolean updateWasMade = cs.updateCustomer(this.loggedInCustomer);
		
	}
	
	private void viewAccountInfo() {
		System.out.println("You want to look at your account info? Super!");

		Account account = as.findByAccountNumber(this.loggedInCustomer.getAccount().getAccountNumber());
		System.out.println("Here is your account information: " + account);
		customerMenu();
	}
	
	private void makeDeposit() {
		System.out.println("You're here to make a deposit? Neat!");
		System.out.println("Would you like to make a deposit in your checking account or saving account? [check/save]");
		String depositAnswer = scan.nextLine();
		
		if (depositAnswer.toLowerCase().equals("check")) {
			
			Account account = this.loggedInCustomer.getAccount();
			
			System.out.println("What is the amount you would like to add to your checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
			
			
			if(as.depositChecking(account, checkAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again.");
				customerMenu();
			}
			
		} else if (depositAnswer.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to add to your saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			Account account = this.loggedInCustomer.getAccount();
			
			if (as.depositSaving(account, saveAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again!");
				customerMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			customerMenu();
		}
		
		System.out.println("returning to the customer menu!");
		customerMenu();
		
	}
	
	private void employeeLogin() {
		System.out.println("What is your employee id?");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("What is your password?");
		String password = scan.nextLine();
		
		this.loggedInEmployee = es.employeeLogin(id, password);
		System.out.println("Ah, we found you!");
		
		employeeMenu();
	}

	private void employeeMenu() {
		System.out.println("Welcome to the employee menu!");
		System.out.println("[1] View all customers. \n "
				+ "[2] View a specific customer's personal information. \n "
				+ "[3] View a specific customer's account information. \n "
				+ "[4] Approve an account. \n "
				+ "[5] Go to the admin menu. \n "
				+ "[6] I am ready to leave!");
		String empMenuAnswers = scan.nextLine();
		employeeSwitch(empMenuAnswers);
		
	}

	private void employeeSwitch(String empMenuAnswers) {
		switch (empMenuAnswers) {
		case "1":
			//view all customers
			viewAllCustomers();
			break;
		case "2":
			//view specific customer personal info
			viewPersonalCustomerInfo();
			break;
		case "3":
			//view specific customer account info
			viewAccountCustomerInfo();
			break;
		case "4":
			//approve account
			approveAccount();
			break;
		case "5":
			//admin menu
			adminMenu();
			break;
		case "6":
			//exit
			System.out.println("Have a good day!");
			break;
		default:
			System.out.println("You have entered an incorrect value, please try again.");
			employeeMenu();
			break;
		}
		
	}


	private void adminMenu() {
		if (this.loggedInEmployee.isAdmin() == false) {
			System.out.println("ACCESS DENIED. This menu is for admin employees only!");
			System.out.println("Returning to employee menu.");
			employeeMenu();
			return;
		} 
		System.out.println("Welcome to the admin menu!");
		System.out.println("[1] Deposit into an account. \n "
				+ "[2] Withdrawal from an account. \n "
				+ "[3] Transfer funds from an account. \n "
				+ "[4] Cancel an account. \n "
				+ "[5] I'm ready to leave!. \n ");
		String adminAnswers = scan.nextLine();
		adminSwitch(adminAnswers);
		
	}

	private void adminSwitch(String adminAnswers) {
		switch(adminAnswers) {
		case "1":
			//deposit 
			depositIntoAccount();
			break;
		case "2":
			//withdrawal
			withdrawalFromAccount();
			break;
		case "3":
			//transfer
			transferFromAccounts();
			break;
		case "4":
			//cancel
			cancelAccount();
			break;
		case "5":
			//exit
			System.out.println("Have a nice day!");
			break;
		default:
			System.out.println("You have entered an incorrect value, please try again.");
			adminMenu();
			break;
		}
		
	}

	private void cancelAccount() {
		System.out.println("Oh man, we need to cancel an account? Bummer.");
		System.out.println("Please enter the account number of the account to be canceled.");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		Account account = as.findByAccountNumber(accountNumber);
		as.cancelAccount(account);
		
		System.out.println("Returning to admin menu.");
		adminMenu();
	}

	private void transferFromAccounts() {
		System.out.println("Let's transfer funds between accounts!");
		System.out.println("Please enter the account number for this transfer.");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		Account account = as.findByAccountNumber(accountNumber);
		System.out.println(account);
		
		System.out.println("Will the transfer be from the checking account or saving account? [check/save]");
		String tansferAnswer = scan.nextLine();
		
		if (tansferAnswer.toLowerCase().equals("check")) {
		
			System.out.println("What is the amount you would like to remove from your checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
		
			if(as.transferFromCheckToSave(account, checkAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again.");
				adminMenu();
			}
			
		} else if (tansferAnswer.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to remove from your saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			if (as.transferFromSaveToCheck(account, saveAmount)) {
				System.out.println("The amount was removed!");
			} else {
				System.out.println("Something went wrong, please try again!");
				adminMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			adminMenu();
		}
		System.out.println("Returning to admin menu.");
		adminMenu();
	}

	private void withdrawalFromAccount() {
		System.out.println("Let's make a withdrawal from an account!");
		System.out.println("Please enter the account number for this withdrawal.");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		Account account = as.findByAccountNumber(accountNumber);
		System.out.println(account);
		
		System.out.println("Will the withdrawal be from the checking account or saving account? [check/save]");
		String accountType = scan.nextLine();
		if (accountType.toLowerCase().equals("check")) {
			
			System.out.println("What is the amount you would like to remove from the checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
			
			
			if(as.withdrawChecking(account, checkAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again.");
				adminMenu();
			}
			
		} else if (accountType.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to remove from the saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			if (as.withdrawSaving(account, saveAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again!");
				adminMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			adminMenu();
		}
		
		System.out.println("Returning to admin menu.");
		adminMenu();
	}

	private void depositIntoAccount() {
		System.out.println("Let's make a deposit into an account!");
		System.out.println("Please enter the account number for this deposit.");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		Account account = as.findByAccountNumber(accountNumber);
		System.out.println(account);
		
		System.out.println("Will the deposit be into the checking account or saving account? [check/save]");
		String accountType = scan.nextLine();
		if (accountType.toLowerCase().equals("check")) {
			
			System.out.println("What is the amount you would like to add to the checking account?");
			double checkAmount = scan.nextDouble();
			scan.nextLine();
			
			
			if(as.depositChecking(account, checkAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again.");
				adminMenu();
			}
			
		} else if (accountType.toLowerCase().equals("save")) {
	
			System.out.println("What is the amount you would like to add to the saving account?");
			double saveAmount = scan.nextDouble();
			scan.nextLine();
			
			if (as.depositSaving(account, saveAmount)) {
				System.out.println("The amount went through!");
			} else {
				System.out.println("Something went wrong, please try again!");
				adminMenu();
			}
			
		} else {
			System.out.println("You did not enter a correct value, let's start over!");
			adminMenu();
		}
		
		System.out.println("Returning to admin menu");
		adminMenu();
	}

	private void approveAccount() {
		System.out.println("Let's see what accounts need to be approved!");
		List<Account> list =es.findApproveAccount();
		System.out.println("Please enter the account number of the account you wish to approve.");
		for(Account account : list) {
			System.out.println(account);
		}
		int accountNumber = scan.nextInt();
		scan.nextLine();
		Account account = es.viewCustAccInfo(accountNumber);
		as.approveAccount(account);
		
		System.out.println("Returning to employee menu.");
		employeeMenu();
	}

	private void viewAllCustomers() {
		System.out.println("Let's see all the customers in the database!");
		List<Customer> list = es.findAll();
			for(Customer customer : list) {
				System.out.println(customer);
			}
		System.out.println("Returning to employee menu.");
		employeeMenu();
	}
	

	private void viewPersonalCustomerInfo() {
		System.out.println("Let's find a specific customer's personal information!");
		System.out.println("What is the customer id?");
		int id = scan.nextInt();
		scan.nextLine();
		
		Customer customer = es.viewCustPersInfo(id);
		System.out.println(customer);
		
		System.out.println("Returning to employee menu.");
		employeeMenu();
	}
	
	private void viewAccountCustomerInfo() {
		System.out.println("Let's find a specific customer's account information!");
		System.out.println("What is the account number?");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		Account account = es.viewCustAccInfo(accountNumber);
		System.out.println(account);
		
		System.out.println("Returning to employee menu.");
		employeeMenu();
		
	}
	
	











}
