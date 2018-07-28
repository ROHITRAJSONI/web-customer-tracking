package com.alight.springdemo.dao;

import java.util.List;

import com.alight.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void saveCustomer(Customer theCustomer);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

}
