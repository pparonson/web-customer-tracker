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
	public List<Customer> getCustomers() {
		
		// get current Hibernate session
		Session currentSession =  sessionFactory.getCurrentSession();
		
		// create query..  sort by last name
		Query<Customer> query = 
				currentSession.createQuery("from Customer order by lastName", 
						Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query to save customer
//		currentSession.save(customer);
		currentSession.saveOrUpdate(customer);
		System.out.println("Saved.");
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve customer with appropriate customerId from DB
		Customer customer = currentSession.get(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete customer obj with appropriate customerId from Db
		Query query = currentSession
				.createQuery("delete from Customer c where c.id=:customerId");
		query.setParameter("customerId", customerId);
		System.out.println("Customer ID: " + customerId);
		
		// commit the transaction
		query.executeUpdate();
		
	
		
	}
	

}
