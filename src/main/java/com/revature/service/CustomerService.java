package com.revature.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDAO;
import com.revature.dao.ICustomerDAO;
import com.revature.model.Customer;

public class CustomerService {

	private static ICustomerDAO dao = new CustomerDAO();
	private static final Logger log = LogManager.getLogger(CustomerService.class);
	
	public List<Customer> findAll() {
		log.info("Gathering all the customers!");
		return dao.findAll();	
	}
	
	public boolean updateCustomer (Customer c) {
		if(dao.updateCustomer(c)) {
			return true;
		} else {
			log.warn("Something went wrong updating the customer.");
			return false;
		}
	}
	
	public boolean removeCustomer (int customerId) {
		if (dao.deleteCustomer(customerId)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean addCustomer (Customer c) {
		log.info("Adding new customer");
		if (dao.addCustomer(c)) {
			return true;
		} else {
			return false;
		}
	}

	public Customer loginCustomer (int customerId, String password) {
		log.info("Validating the customer id and password");
		return dao.findByIdAndPassword(customerId, password);
	}
	
	
	
	
	
}
