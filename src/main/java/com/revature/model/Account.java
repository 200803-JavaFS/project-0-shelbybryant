package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable{


	private static final long serialVersionUID = 1L;

	
//the account instance variables
	private int accountNumber;
	private double checkingsBalance;
	private double savingsBalance;
	private double previousCheckingTransaction;
	private double previousSavingTransaction;
	private boolean approved;
	private boolean canceled;
	
	protected static int customerCount = 0;

	
//	public CustomerAccount(String firstName, String lastName, String password, String phone, String streetAddress, String city,
//			String state, int zip) {
//		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
//		customerId = ++customerCount;
//	}
	
	
	public Account() {
		super();
		
	}
	
	
	
	public Account(int accountNumber, double checkingsBalance, double savingsBalance, double previousCheckingTransaction,
		double previousSavingTransaction, boolean approved, boolean canceled) {
	super();
	this.accountNumber = accountNumber;
	this.checkingsBalance = checkingsBalance;
	this.savingsBalance = savingsBalance;
	this.previousCheckingTransaction = previousCheckingTransaction;
	this.previousSavingTransaction = previousSavingTransaction;
	this.approved = approved;
	this.canceled = canceled;
}



	public double getPreviousCheckingTransaction() {
		return previousCheckingTransaction;
	}
	

	public void setPreviousCheckingTransaction(double previousCheckingTransaction) {
		this.previousCheckingTransaction = previousCheckingTransaction;
	}

	public double getPreviousSavingTransaction() {
		return previousSavingTransaction;
	}

	public void setPreviousSavingTransaction(double previousSavingTransaction) {
		this.previousSavingTransaction = previousSavingTransaction;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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


	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}



	public boolean isCanceled() {
		return canceled;
	}



	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}



	@Override
	public String toString() {
		return "Account [accountNumber= " + accountNumber + ", checkingsBalance= " + checkingsBalance
				+ ", savingsBalance= " + savingsBalance + ", previousCheckingTransaction= " + previousCheckingTransaction
				+ ", previousSavingTransaction= " + previousSavingTransaction + ", approved= " + approved + ", canceled= "
				+ canceled + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + (canceled ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(checkingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(previousCheckingTransaction);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(previousSavingTransaction);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (approved != other.approved)
			return false;
		if (canceled != other.canceled)
			return false;
		if (Double.doubleToLongBits(checkingsBalance) != Double.doubleToLongBits(other.checkingsBalance))
			return false;
		if (Double.doubleToLongBits(previousCheckingTransaction) != Double
				.doubleToLongBits(other.previousCheckingTransaction))
			return false;
		if (Double.doubleToLongBits(previousSavingTransaction) != Double
				.doubleToLongBits(other.previousSavingTransaction))
			return false;
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		return true;
	}


	
	
	
	
}
