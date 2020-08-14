package com.revature.model;

public class Employee extends User {

	protected int employeeId;
	protected double employeeSalary;
	
	//view account info
	public void viewCustAccInfo(CustomerAccount customerAccount) {
		int accNumber = customerAccount.getAccountNumber();
		double checkBalance = customerAccount.getCheckingsBalance();
		double saveBalance = customerAccount.getSavingsBalance();
	}
	
	
	//view personal info
	public void viewCustPersInfo(User user) {
		String customerFirstName = user.getFirstName();
		String customerLastName = user.getLastName();
		String customerPhone = user.getPhone();
		
	
	}


	Employee(String firstName, String lastName, String password, String phone, String streetAddress, String city, String state, int zip) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	
	
}
