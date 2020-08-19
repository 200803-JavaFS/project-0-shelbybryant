package com.revature.model;

import java.io.Serializable;

public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
		private String firstName;
		private String lastName;
		private String password;
		private String phone;
		private String streetAddress;
		private String city;
		private String state;
		private int zip;
		
	


		public User() {
			super();
			// TODO Auto-generated constructor stub
		}


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
			return this.firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return this.lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		
		

		public String getStreetAddress() {
			return this.streetAddress;
		}


		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}


		public String getCity() {
			return this.city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return this.state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public int getZip() {
			return this.zip;
		}


		public void setZip(int zip) {
			this.zip = zip;
		}


		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", phone="
					+ phone + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zip="
					+ zip + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
			result = prime * result + zip;
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
			User other = (User) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			if (streetAddress == null) {
				if (other.streetAddress != null)
					return false;
			} else if (!streetAddress.equals(other.streetAddress))
				return false;
			if (zip != other.zip)
				return false;
			return true;
		}




	
	
}
