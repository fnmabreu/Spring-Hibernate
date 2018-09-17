package com.omega.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Instructor;
import com.omega.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// Create session factory
		//
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		// Create session
		//
		Session session = factory.getCurrentSession();

		try {
			// create the objects
//			Instructor tempInstructor = new Instructor("John", "Darby", "darby@teste.pt");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/darby", "Programmer");
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@teste.pt");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/madhu", "Guitar");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

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
