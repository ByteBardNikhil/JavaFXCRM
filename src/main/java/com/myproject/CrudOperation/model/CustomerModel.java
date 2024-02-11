package com.myproject.CrudOperation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.myproject.CrudOperation.dao.CustomerDAO;
import com.myproject.CrudOperation.util.HibernateUtil;

import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerModel implements CustomerDAO {

	@Override
	public ObservableList getAllCustomers() {
		ObservableList<Customer> customers = FXCollections.observableArrayList();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "FROM Customer";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			customers.addAll(query.getResultList());
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

}
