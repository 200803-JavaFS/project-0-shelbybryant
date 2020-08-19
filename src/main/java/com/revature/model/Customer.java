package com.revature.model;

public class Customer extends User{


	private static final long serialVersionUID = 1L;
	
	private int customerId;
	private Account account;
	
	//no args
	public Customer() {
		super();
	}
	
	//all fields from super class WITHOUT the customer id
	public Customer(String firstName, String lastName, String password, String phone, String streetAddress, String city,
			String state, int zip, Account account) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
		this.account = account;
		
	}

	//with the customer id
	public Customer(int customerId, String firstName, String lastName, String password, String phone, String streetAddress, String city,
			String state, int zip, Account account) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
		this.customerId = customerId;
		this.account = account;
	}
	
	public Customer(String firstName, String lastName, String password, String phone, String streetAddress, String city,
			String state, int zip) {
		super(firstName, lastName, password, phone, streetAddress, city, state, zip);
		
		
	}
	
	
//	public String getPassword() {
//		return super.getPassword();
//	}
//
//	public String getFirstName() {
//		return super.getFirstName();
//	}		@Override
	public String toString() {
		return "User [customerId = " + customerId + "firstName = " + super.getFirstName() + ", lastName = " + super.getLastName() + ", password = " + super.getPassword() + ", phone = "
				+ super.getPhone() + ", streetAddress = " + super.getStreetAddress() + ", city = " + super.getCity() + ", state = " + super.getState() + ", zip = "
				+ super.getZip() + "account = " + account + "]";
	}
	


	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	
	
}
