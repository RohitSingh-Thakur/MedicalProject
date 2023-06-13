package com.rdst.base.configuration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rdst.base.entity.Customer;
import com.rdst.base.entity.Medicine;
import com.rdst.base.entity.User;

public class HibernateConfiguratinProvider {

		public static SessionFactory getSessionFactory()
		{
			Configuration configuration = new Configuration();
			configuration.configure("HBConfig.xml").addAnnotatedClass(User.class).addAnnotatedClass(Medicine.class).addAnnotatedClass(Customer.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		}
}
