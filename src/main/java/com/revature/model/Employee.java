package com.revature.model;

public class Employee extends User {


	private static final long serialVersionUID = 1L;
	
	private int employeeId;
	private boolean isAdmin;



	Employee(String firstName, String lastName, String password, String phone, String streetAddress, String city, String state, int zip, boolean isAdmin) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
	}

	public Employee(int employeeId, String firstName, String lastName, String password, boolean isAdmin){
		this.employeeId = employeeId;
		this.isAdmin = isAdmin;
	}

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	
	
}
