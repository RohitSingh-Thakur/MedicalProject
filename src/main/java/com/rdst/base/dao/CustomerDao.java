package com.rdst.base.dao;

import java.util.List; 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rdst.base.configuration.HibernateConfiguratinProvider;
import com.rdst.base.entity.Customer;

public class CustomerDao {
	public static String addNewCustomer(Customer customer) {
		String message = null;
		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession();) {
			session.save(customer);
			session.beginTransaction().commit();
			message = "Customer Added Successfully...";

		} catch (Exception e) {
			e.printStackTrace();
			message = "Customer Not Added...";
		}
		return message;
	}
	
	public static String deleteCustomerById(Integer customerId) {
		String message = null;
		
		try(SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()){
			
			Customer customer = session.get(Customer.class, customerId);
			
			if(customer != null) {
				session.delete(customer);
				session.beginTransaction().commit();
				message = "Customer Deleted Successfully....";
			}else {
				message = "No Recored Found For Given ID : " + customerId;
			}

		}catch (Exception e) {
			e.printStackTrace();
			message = "Something Went Wrong...";
		}
		
		return message;
	}
	
	public static Customer getCustomerById(Integer customerId) {
		Customer customer = null;
		
		try(SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()){
			
			customer = session.get(Customer.class, customerId);
			
		}catch (Exception e) {
			e.printStackTrace();
			customer = null;
		}
		
		
		return customer;
	}
	
	public static List<Customer> getAllCustomerDetails()
	{
		List<Customer> customerList = null;
		
		try(SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()){
			
			Criteria criteria = session.createCriteria(Customer.class);
			customerList = criteria.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			customerList = null;
		}
		
		return customerList;
	}
}
