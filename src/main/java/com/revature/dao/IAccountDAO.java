package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface IAccountDAO {
	
	public List<Account> findAll();
	public boolean addAccount(Account a);
	public Account findByAccountNumber(int accountNumber);
	public boolean updateAccount(Account a);
	
	
}
