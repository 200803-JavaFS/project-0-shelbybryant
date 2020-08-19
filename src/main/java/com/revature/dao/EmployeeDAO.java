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
import com.revature.model.Employee;
import com.revature.utils.ConnectionUtility;

public class EmployeeDAO implements IEmployeeDAO{

	private IAccountDAO aDao = new AccountDAO();
	
	@Override
	public List<Customer> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM customers;";
			Statement statement = conn.createStatement();
			
			List<Customer> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Customer c = new Customer(result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("customer_password"),
						result.getString("phone_number"),
						result.getString("street_address"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zip_code"),
						null);
				if(result.getInt("account_number_fk") != 0) {
					c.setAccount(aDao.findByAccountNumber(result.getInt("account_number_fk")));
				}
				list.add(c);
			}
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Account viewAccountInfo(int accountNumber) {
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
	public Customer viewPersonalInfo(int customerId) {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM customers WHERE customer_id = " + customerId +";";
			
			Statement statement = conn.createStatement();
		
			
			ResultSet result = statement.executeQuery(sql);
			
			
			if(result.next()) {
				Customer c = new Customer(result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("customer_password"),
						result.getString("phone_number"),
						result.getString("street_address"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zip_code"),
						null);
				if(result.getInt("account_number_fk") != 0) {
					c.setAccount(aDao.findByAccountNumber(result.getInt("account_number_fk")));
				}
				return c;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean approvedAccount(Account account) {
		
		return false;
	}

	@Override
	public Employee employeeLogin(int employeeId, String password) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM employees WHERE employee_id = " + employeeId + ";";
			String sql2 = "SELECT * FROM employees WHERE employee_password = " + password + ";";
			
			Statement statement = conn.createStatement();
			PreparedStatement pstatement = conn.prepareStatement(sql2);
			
		
			ResultSet result = statement.executeQuery(sql);
			
			
			if(result.next()) {
				Employee employee = new Employee(result.getInt("employee_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("employee_password"),
						result.getBoolean("is_admin"));

				return employee;
			}
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> findApproveAccounts() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE approved_account = FALSE;";
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account account = new Account(result.getInt("account_number"),
						result.getDouble("checkings_balance"),
						result.getDouble("savings_balance"),
						result.getDouble("previous_checking_transaction"),
						result.getDouble("previous_saving_transaction"),
						result.getBoolean("approved_account"),
						result.getBoolean("canceled_account"));

				list.add(account);
			}
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
	
	
}		


	
		
	

	

