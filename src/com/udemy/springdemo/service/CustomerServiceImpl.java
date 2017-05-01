package com.udemy.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.springdemo.dao.ICustomerDAO;
import com.udemy.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	// inject customer DAO
	@Autowired
	ICustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegates getCustomers to DAO
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}
	
	

}
