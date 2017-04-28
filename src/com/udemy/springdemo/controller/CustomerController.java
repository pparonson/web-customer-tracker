package com.udemy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springdemo.dao.ICustomerDAO;
import com.udemy.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// inject customer DAO; ie Spring will scan for a component that impl ICustomerDAO interface
	@Autowired
	private ICustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// get customers from the DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		// add customers to Spring MVC model using name and value of customers
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
