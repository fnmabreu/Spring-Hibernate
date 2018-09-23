package com.omega.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Course;
import com.omega.hibernate.demo.entity.Instructor;
import com.omega.hibernate.demo.entity.InstructorDetail;
import com.omega.hibernate.demo.entity.Review;
import com.omega.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		//
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// Create session
		//
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the pacman course from database
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			// delete the course
			System.out.println("Deleting course: " + tempCourse);
			
			session.delete(tempCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
