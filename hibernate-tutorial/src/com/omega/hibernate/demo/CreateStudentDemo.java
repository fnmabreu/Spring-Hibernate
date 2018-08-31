package com.omega.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Student;
import com.omega.hibernate.utils.DateUtils;

public class CreateStudentDemo {

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
			// create a student object
			System.out.println("Creating a new student object...");
            Date theDateOfBirth = DateUtils.parseDate("31/12/2001");
            
			Student tempStudent = new Student("John", "Wall", "john@student.com", theDateOfBirth);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);

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
