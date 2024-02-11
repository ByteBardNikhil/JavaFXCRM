package com.myproject.CrudOperation.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myproject.CrudOperation.util.HibernateUtil;

import entity.Customer;

public class DatabaseSave {
	
	
	public void updateData(Customer customer) {
        // Get the current Hibernate session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // Begin a transaction
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Update the Customer record
            session.update(customer);

            // Commit the transaction
            transaction.commit();
            
            System.out.println("Customer record updated successfully.");
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error updating customer record: " + e.getMessage());
        } finally {
            // Ensure the session is closed to release resources
            session.close();
        }
    }
	
	
	public void removeData(Customer customer) {
        // Get the current Hibernate session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        // Begin a transaction
        session.beginTransaction();
        
        try {
            // Delete the customer
            session.delete(customer);
            System.out.println("Customer with ID " + customer.getId() + " removed successfully.");
            
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
	
	
	public void saveData(Customer c)
	{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
		    if (session != null) { // Check if session is not null

		        // Begin transaction
		        session.beginTransaction();


		 
		        session.save(c);

		 
		        session.getTransaction().commit();

		    
		    } else {
		        System.out.println("Session is null. Cannot proceed.");
		 
		    }
		} catch (Exception e) {
		 
		    if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
		        session.getTransaction().rollback();
		    }
		    e.printStackTrace();
		} finally {
		    // Close the session and factory if session is not null
		    if (session != null) {
		        session.close();
		    }
		}
	}
	
	
	

}
