package com.udemy.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {
	
	// Inject Hibernate SessionFactory; sessionFactory refs bean id in cfg
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get current Hibernate session
		Session currentSession =  sessionFactory.getCurrentSession();
		System.out.println("at currentSession obj");
		
		// create query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		System.out.println("at query obj");
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		System.out.println("at customers obj");	
		
		// return results
		return customers;
	}

}
