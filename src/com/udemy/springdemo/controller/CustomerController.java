package com.udemy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.springdemo.dao.ICustomerDAO;
import com.udemy.springdemo.entity.Customer;
import com.udemy.springdemo.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//	// inject customer DAO; ie Spring will scan for a component that impl ICustomerDAO interface
//	@Autowired
//	private ICustomerDAO customerDAO;
	
	// now using customer service layer
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from the DAO
//		List<Customer> customers = customerDAO.getCustomers();
		
		// now using customer service layer to get customers
		List<Customer> customers = customerService.getCustomers();
		
		// add customers to Spring MVC model using name and value of customers
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showCustomerCreateForm")
	public String showCustomerCreateForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save customer using customer service layer
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showCustomerEditForm")
	public String showCustomerEditForm(@RequestParam("customerId") int customerId, Model model) {
		// get the customer with appropriate customerId from service
		Customer customer = customerService.getCustomer(customerId);
		
		// set customer as a model attribute pre-populate the form
		model.addAttribute("customer", customer);
		
		// send to form
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model model) {
		// delete the customer
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
		
	}
	
}
