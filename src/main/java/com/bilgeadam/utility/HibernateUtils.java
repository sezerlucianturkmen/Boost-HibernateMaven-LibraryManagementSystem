package com.bilgeadam.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.Borrow;
import com.bilgeadam.entity.Debt;
import com.bilgeadam.entity.Employee;
import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;

public class HibernateUtils {

	// hibernate ile baðlantýmýzý kuracak

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			// Entity claslarýmýzý buraya ekliyoruz
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(UserInformation.class);
			configuration.addAnnotatedClass(PhoneNumber.class);
			configuration.addAnnotatedClass(Address.class);
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Book.class);
			configuration.addAnnotatedClass(Author.class);
			configuration.addAnnotatedClass(Borrow.class);
			configuration.addAnnotatedClass(Debt.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}