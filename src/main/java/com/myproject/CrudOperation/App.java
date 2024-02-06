package com.myproject.CrudOperation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myproject.CrudOperation.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Customer.class);
        configuration.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();

        // Obtain Session from SessionFactory
        Session session = factory.getCurrentSession();

        try {
            // Begin transaction
            session.beginTransaction();

         // Create a new Customer object using the parameterized constructor
            Customer customer = new Customer("John", "Doe", "1990-01-01", "Engineer", "50000");

         

            // Save the Customer object to the database
            session.save(customer);
            // Commit transaction (this will trigger schema generation)
            session.getTransaction().commit();

            System.out.println("Schema created successfully!");
        } catch (Exception e) {
            // Rollback transaction if an error occurs
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Close the session and factory
            session.close();
            factory.close();
        }
    }
}
