package com.revature.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.IAccountDAO;
import com.revature.dao.IEmployeeDAO;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;


public class EmployeeService {
	
	
	private IEmployeeDAO eDao = new EmployeeDAO();
	private IAccountDAO aDao = new AccountDAO();
	private static final Logger log = LogManager.getLogger(EmployeeService.class);
	
	//see all customers
	public List<Customer> findAll(){
		return eDao.findAll();
	}
	
	//view account info
	public Account viewCustAccInfo(int accountNumber) {
		log.info("Searching for account with accountNumber:" + accountNumber);
		return eDao.viewAccountInfo(accountNumber);
	}
	
	
	//view personal info
	public Customer viewCustPersInfo(int customerId) {
		log.info("Searching for customer with customerId:" + customerId);
		return eDao.viewPersonalInfo(customerId);

	}
	
	public boolean approveAccount(Account a, boolean isApproved) {
		log.info("Approving an account");
		a.setApproved(isApproved);
		return aDao.updateAccount(a);
	}
	
	public Employee employeeLogin(int employeeId, String password) {
		log.info("Employee is logging in.");
		return eDao.employeeLogin(employeeId, password);
	}
	
	public List<Account> findApproveAccount() {
		return eDao.findApproveAccounts();
	}
	
	
	
}
