package com.omega.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Student;
import com.omega.hibernate.utils.DateUtils;

public class ReadStudentDemo {

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
			
            Date theDateOfBirth = DateUtils.parseDate("31/12/1988");
			Student tempStudent = new Student("Jason", "Paul", "jason@student.com", theDateOfBirth);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete: " + myStudent);

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
