package com.udemy.springdemo.dao;

import java.util.List;

import com.udemy.springdemo.entity.Customer;

public interface ICustomerDAO {
	public List<Customer> getCustomers();
}
