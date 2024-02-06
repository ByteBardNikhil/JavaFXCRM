package com.myproject.CrudOperation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.getCurrentSession();
    	
    	System.out.print(factory);
    	
    }
}
