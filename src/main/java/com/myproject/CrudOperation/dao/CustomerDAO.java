package com.myproject.CrudOperation.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.myproject.CrudOperation.util.HibernateUtil;

import entity.Customer;


public interface CustomerDAO {
	
	
    public List<Customer> getAllCustomers();
    
    // Method to save a customer to the database
    public void saveCustomer(Customer customer) ;
}
