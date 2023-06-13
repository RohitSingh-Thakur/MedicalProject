package com.rdst.base.dao;

import static com.rdst.base.utility.ColorCodes.Reset; 

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rdst.base.configuration.HibernateConfiguratinProvider;
import com.rdst.base.entity.User;

public class UserDao {
	public static String addNewUser(User user) {
		String message = null;
		System.out.println(Reset);
		try (SessionFactory sessionFactory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = sessionFactory.openSession()) {

			session.save(user);
			session.beginTransaction().commit();

			message = "Record Stored Successfully....";

		} catch (Exception e) {
			e.printStackTrace();
			message = "Something Went Wrong....";
		}
		return message;
	}

	public static List<User> getUsersDetails() {

		List<User> userList = null;

		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			Criteria criteria = session.createCriteria(User.class);
			userList = criteria.list();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;
	}
	
	public static String deleteUserDetails(Integer userId) {
		String message = null;
		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {
			
			User user = session.get(User.class, userId);
			
			if(user != null) {
				session.delete(user);
				session.beginTransaction().commit();
				message = "User Details Deleted..";
			}else {
				message = "No Recored Found For Given ID : " + userId;
			}
			
		}catch (Exception e) {
			message = "No Record Found For Given Id" + userId;
			e.printStackTrace();

		}
		
		return message;
	}
	
	public static User getUserById(Integer userId) {
		User user = null;
		
		try(SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession())
		{
			user = session.get(User.class, userId);
			
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return user;
	}
	

}
