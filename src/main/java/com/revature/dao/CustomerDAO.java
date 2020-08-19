package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.utils.ConnectionUtility;

public class CustomerDAO implements ICustomerDAO{

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
	public boolean addCustomer(Customer c) {
		
		System.out.println("customer password:" + c.getPassword());
		System.out.println("first name" + c.getFirstName());
		System.out.println("last name" + c.getLastName());
		System.out.println("phone" + c.getPhone());
		System.out.println("strt addr" + c.getStreetAddress());
		System.out.println("city" + c.getCity());
		System.out.println("state" + c.getState());
		System.out.println("zip" + c.getZip());
		
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO customers (customer_id, first_name, last_name, customer_password, phone_number, street_address, city, state, zip_code, account_number_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			int index = 0;
			
			statement.setInt(++index, c.getCustomerId());
			statement.setString(++index, c.getFirstName());
			statement.setString(++index, c.getLastName());
			statement.setString(++index, c.getPassword());
			statement.setString(++index, c.getPhone());
			statement.setString(++index, c.getStreetAddress());
			statement.setString(++index, c.getCity());
			statement.setString(++index, c.getState());
			statement.setInt(++index, c.getZip());

			
			if (c.getAccount() != null) {
				statement.setInt(++index, c.getAccount().getAccountNumber());
			} else {
				statement.setString(++index, null);
			}
			
			
			statement.execute();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean updateCustomer(Customer c) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE customers SET first_name = ?, last_name = ?, customer_password = ?, phone_number = ?, " + 
		"street_address = ?, city = ?, state = ?, zip_code = ?, account_number_fk = ? WHERE customer_id = ?;";
		
		PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, c.getFirstName());
			statement.setString(++index, c.getLastName());
			statement.setString(++index, c.getPassword());
			statement.setString(+index, c.getPhone());
			statement.setString(++index, c.getStreetAddress());
			statement.setString(++index, c.getCity());
			statement.setString(++index, c.getState());
			statement.setInt(++index, c.getZip());
			
			if (c.getAccount() != null) {
				statement.setInt(++index, c.getAccount().getAccountNumber());
			} else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, c.getCustomerId());
			
			statement.execute();
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE * FROM customers WHERE customer_id = " + customerId +";";
			
			Statement statement = conn.createStatement();
			
			statement.executeQuery(sql);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer findByCustomerId(int customerId) {
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
	public Customer findByIdAndPassword(int customerId, String password) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM customers WHERE customer_id = " + customerId + ";";
			String sql2 = "SELECT * FROM customers WHERE customer_password = " + password + ";";
			
			Statement statement = conn.createStatement();
			PreparedStatement pstatement = conn.prepareStatement(sql2);
			
		
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
