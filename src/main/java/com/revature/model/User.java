package com.revature.model;

public class User {

		
		protected String firstName;
		protected String lastName;
		protected String password;
		protected String phone;
		protected String streetAddress;
		protected String city;
		protected String state;
		protected int zip;
		
// static integer to keep track of the number of customers
		//protected static int customerCount = 0;
		
//creating my customer constructor



		public User(String firstName, String lastName, String password, String phone, String streetAddress, String city,
		String state, int zip) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.phone = phone;
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zip = zip;
}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}




	
	
}
