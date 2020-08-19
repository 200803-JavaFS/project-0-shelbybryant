package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;

public interface IEmployeeDAO {

	public List<Customer> findAll();
	public Account viewAccountInfo(int accountNumber);
	public Customer viewPersonalInfo(int customerId);
	public boolean approvedAccount(Account account);
	public Employee employeeLogin(int employeeId, String password);
	public List<Account> findApproveAccounts();
}
