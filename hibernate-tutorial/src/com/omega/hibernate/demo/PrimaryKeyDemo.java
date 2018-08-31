package com.omega.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Student;
import com.omega.hibernate.utils.DateUtils;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// Create session factory
		//
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// Create session
		//
		Session session = factory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			
            Date theDateOfBirth1 = DateUtils.parseDate("31/12/1986");
			Student tempStudent1 = new Student("Paul", "Doe", "paul@student.com", theDateOfBirth1);
			
            Date theDateOfBirth2 = DateUtils.parseDate("01/02/1987");
			Student tempStudent2 = new Student("Mary", "Public", "mary@student.com", theDateOfBirth2);
			
            Date theDateOfBirth3 = DateUtils.parseDate("05/05/1999");
			Student tempStudent3 = new Student("Kevin", "Rich", "kevin@student.com", theDateOfBirth3);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
