package com.revature.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.IAccountDAO;
import com.revature.model.Account;

public class AccountService {

	private static IAccountDAO dao = new AccountDAO();
	private static final Logger log = LogManager.getLogger(AccountService.class);
	
	//deposit methods for checking and saving
	public boolean depositChecking(Account account, double amount) {
		log.info("Deposting $" + amount + " into your checking account.");
		if (amount <= 0.0) {
			log.warn("You cannot give a number less than or equal to 0.");
			return false;
		} 
		if (account.isCanceled()) {
			log.warn("You cannot make a deposit, your account has been canceled.");
			return false;
		}
		
		double newBalance = amount + account.getCheckingsBalance();
		account.setCheckingsBalance(newBalance);
		account.setPreviousCheckingTransaction(amount);
		
		dao.updateAccount(account);
		
		
		return true;
	}
	
	public boolean depositSaving(Account account, double amount) {
		log.info("Depositing $" + amount + " into your saving account.");
		if (amount <= 0.0) {
			log.warn("You cannot give a number less than or equal to 0.");
			return false;
		}
		
		if (account.isCanceled()) {
			log.warn("You cannot make a deposit, your account has been canceled.");
			return false;
		}
		
		double newBalance = amount + account.getSavingsBalance();
		account.setSavingsBalance(newBalance);
		account.setPreviousSavingTransaction(amount);
		
		dao.updateAccount(account);
		return true;
	}
	
	// withdraw methods for checking and saving
	
	public boolean withdrawChecking(Account account, double amount) {
		if (amount <= 0.0) {
			log.warn("You cannot give a number less than or equal to 0.");
			return false;
		}
		
		if (account.isCanceled()) {
			log.warn("You cannot make a withdrawal, your account has been canceled.");
			return false;
		}
		double newBalance = account.getCheckingsBalance() - amount;
		account.setCheckingsBalance(newBalance);
		account.setPreviousCheckingTransaction(-amount);
		dao.updateAccount(account);
		return true;
	}
	
	public boolean withdrawSaving(Account account, double amount) {
		if (amount <= 0.0) {
			log.warn("You cannot give a number less than or equal to 0.");
			return false;
		}
		
		if (account.isCanceled()) {
			log.warn("You cannot make a withdrawal, your account has been canceled.");
			return false;
		}
		double newBalance = account.getSavingsBalance() - amount;
		account.setSavingsBalance(newBalance);
		account.setPreviousSavingTransaction(-amount);
		dao.updateAccount(account);
		return true;
	}

	
	//viewing previous transactions for checking and saving
	
	public void seePreviousCheckingTransaction(Account account) {
		if (account.getPreviousCheckingTransaction() > 0.0) {
			System.out.println("Deposited: $" + account.getPreviousCheckingTransaction() + " into your checking account.");
		} else if (account.getPreviousCheckingTransaction() < 0.0) {
			System.out.println("Withdrawn: $" + Math.abs(account.getPreviousCheckingTransaction()) + " from your checking account.");
		} else {
			System.out.println("No transaction with your checking account occurred.");
		}
	}
	
	public void seePreviousSavingTransaction(Account account) {
		if(account.getPreviousSavingTransaction() > 0.0) {
			System.out.println("Deposited: $" + account.getPreviousSavingTransaction() + " into your savings account.");
		} else if (account.getPreviousSavingTransaction() < 0.0) {
			System.out.println("Withdrawn: $" + account.getPreviousSavingTransaction() + " from your savings account.");
		} else {
			System.out.println("No transaction with your savings account occurred.");
		}
	}
	
	
	//see checking balance
	public double seeCheckingBalance(Account account) {
		return account.getCheckingsBalance();
	}
	
	//see saving balance
	public double seeSavingBalance(Account account) {
		return account.getSavingsBalance();
	}
	
	// dao methods
	
	public Account findByAccountNumber(int accountNumber) {
		log.info("Searching for account with accountNumber:" + accountNumber);
		return dao.findByAccountNumber(accountNumber);

	}
	
	public boolean addAccount(Account a) {
		log.info("Adding the new account");
		if (dao.addAccount(a)) {
			return true;
		} 
		return false;
	}
	
	public boolean approveAccount(Account account) {
		log.info("Approved account.");
		account.setApproved(true);
		return dao.updateAccount(account);
	}
	
	public boolean cancelAccount(Account account) {
		log.info("Canceling account");
		account.setCanceled(true);
		return dao.updateAccount(account);
	}
	
	//transfer money between checking and saving
	public boolean transferFromCheckToSave(Account account, double amount) {
		if(amount > account.getCheckingsBalance()) {
			log.warn("ERROR. Transfer denied due to insufficient funds.");
			return false;
		}
		
		if (account.isCanceled()) {
			log.warn("You cannot make any transfers, your account has been canceled.");
			return false;
		}
		double newCheckBalance = account.getCheckingsBalance() - amount;
		double newSaveBalance = account.getSavingsBalance() + amount;
		account.setCheckingsBalance(newCheckBalance);
		account.setSavingsBalance(newSaveBalance);
		return dao.updateAccount(account);
	}
	
	
	public boolean transferFromSaveToCheck(Account account, double amount) {
		if(amount > account.getSavingsBalance()) {
			log.warn("ERROR. Transfer denied due to insuffiecient funds.");
			return false;
		}
		
		if (account.isCanceled()) {
			log.warn("You cannot make any transfers, your account has been canceled.");
			return false;
		}
		
		double newSaveBalance = account.getSavingsBalance() - amount;
		double newCheckBalance = account.getSavingsBalance() + amount;
		account.setCheckingsBalance(newCheckBalance);
		account.setSavingsBalance(newSaveBalance);
		return dao.updateAccount(account);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
