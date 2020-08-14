package com.revature.model;

public class Admin extends Employee {

	
	protected double adminSalary;
	
	
	Admin(String firstName, String lastName, String password, String phone, String streetAddress, String city, String state, int zip) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
		
	}

	public double getAdminSalary() {
		return adminSalary;
	}


	public void setAdminSalary(double adminSalary) {
		this.adminSalary = adminSalary;
	}

	//approve/decline accounts
	
	public void approveAccount() {
		
	}
	
	public void declineAccount() {
		
	}
	//withdraw, deposit, transfer from all accounts
	
	public void depositForCustomer() {
		
	}
	
	public void withdrawForCustomer() {
		
	}
	
	//cancel accounts
	public void cancelAccount() {
		
	}
	
	
}
