package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements IAccountDAO{

	@Override
	public List<Account> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts;";
			Statement statement = conn.createStatement();
			List<Account> list = new ArrayList();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account a = new Account();
				a.setAccountNumber(result.getInt("account_number"));
				a.setCheckingsBalance(result.getDouble("checkings_balance"));
				a.setSavingsBalance(result.getDouble("savings_balance"));
				a.setPreviousCheckingTransaction(result.getDouble("previous_checking_transaction"));
				a.setPreviousSavingTransaction(result.getDouble("previous_saving_transaction"));
				a.setApproved(result.getBoolean("approved_account"));
				a.setCanceled(result.getBoolean("canceled_account"));
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO accounts (account_number, checkings_balance, savings_balance, previous_checking_transaction, previous_saving_transaction, approved_account, canceled_account) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			int index = 0;
			statement.setInt(++index, a.getAccountNumber());
			statement.setDouble(++index, a.getCheckingsBalance());
			statement.setDouble(++index, a.getSavingsBalance());
			statement.setDouble(++index, a.getPreviousCheckingTransaction());
			statement.setDouble(++index, a.getPreviousSavingTransaction());
			statement.setBoolean(++index, a.isApproved());
			statement.setBoolean(++index, a.isCanceled());
			
			
			
			statement.execute();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account findByAccountNumber(int accountNumber) {
		try (Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE account_number = " + accountNumber +";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				Account a = new Account();
				a.setAccountNumber(result.getInt("account_number"));
				a.setCheckingsBalance(result.getDouble("checkings_balance"));
				a.setSavingsBalance(result.getDouble("savings_balance"));
				a.setPreviousCheckingTransaction(result.getDouble("previous_checking_transaction"));
				a.setPreviousSavingTransaction(result.getDouble("previous_saving_transaction"));
				a.setApproved(result.getBoolean("approved_account"));
				a.setCanceled(result.getBoolean("canceled_account"));
				return a;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String sql = "UPDATE accounts SET checkings_balance = ?, savings_balance = ?, previous_checking_transaction = ?, previous_saving_transaction = ?, " + 
		"approved_account = ?, canceled_account = ? WHERE account_number = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, a.getCheckingsBalance());
			statement.setDouble(++index, a.getSavingsBalance());
			statement.setDouble(++index, a.getPreviousCheckingTransaction());
			statement.setDouble(++index, a.getPreviousSavingTransaction());
			statement.setBoolean(++index, a.isApproved());
			statement.setBoolean(++index, a.isCanceled());
			statement.setInt(++index, a.getAccountNumber());
			
			statement.execute();
			return true;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
