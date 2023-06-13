package com.rdst.base.dao;

import java.util.List; 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rdst.base.configuration.HibernateConfiguratinProvider;
import com.rdst.base.entity.User;
public class DataBaseDao {


	@SuppressWarnings("deprecation")
	public static String loginController(String userName,String password)
	{
		List<User> list = null;
		String message = null;
		
		try(SessionFactory sessionFactory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = sessionFactory.openSession()) {
			
			Criteria criteria = session.createCriteria(User.class);
			list = criteria.list();
			
			for (User u : list) {
				if(u.getUserName().equals(userName) && u.getPassword().equals(password))
				{
					message = "Login Successfull...";
					break;
				}else {
					message = "Wrong Credentials...";
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Something Went Wrong....";
		}
		return message;
	}
	
	
	
	
	
	
	
}
