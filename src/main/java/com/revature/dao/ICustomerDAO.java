package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface ICustomerDAO {

	public List<Customer> findAll();
	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(int customerId);
	public Customer findByCustomerId(int customerId);
	public Customer findByIdAndPassword(int customerId, String password);
	
	
	
}
