package com.alight.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alight.springdemo.dao.CustomerDAO;
import com.alight.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	//Need to inject Customer Dao
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer customer = customerDAO.getCustomer(theId);
		return customer;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

}
