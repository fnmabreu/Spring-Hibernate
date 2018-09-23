package com.omega.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omega.hibernate.demo.entity.Course;
import com.omega.hibernate.demo.entity.Instructor;
import com.omega.hibernate.demo.entity.InstructorDetail;
import com.omega.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		//
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		// Create session
		//
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Million Points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great Course ... love it!"));
			tempCourse.addReview(new Review("Cool course, job well done!"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course ... and leverage the cascade all
			System.out.println("Saving the course\n" + tempCourse + "\n" + tempCourse.getReviews());
			session.save(tempCourse);
			
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
