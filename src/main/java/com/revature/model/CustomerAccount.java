package com.revature.model;

public class CustomerAccount extends User{

	
//the customer instance variables	
	protected int customerId;
	

	
//the account instance variables
	protected int accountNumber;
	protected double checkingsBalance;
	protected double savingsBalance;
	protected double previousTransaction;
	protected boolean approved;
	protected boolean canceled;
	
	protected static int customerCount = 0;

	
	public CustomerAccount(String firstName, String lastName, String password, String phone, String streetAddress, String city,
			String state, int zip) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
		customerId = ++customerCount;
	}
	
	//maybe prevtrans for checking and saving accounts
	
	public void previousTransaction () {
		if (previousTransaction > 0.0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0.0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transactions occured.");
		}
	}
	
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getPreviousTransaction() {
		return previousTransaction;
	}

	public double getCheckingsBalance() {
		return checkingsBalance;
	}

	public void setCheckingsBalance(double checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	
	
	
	
}
