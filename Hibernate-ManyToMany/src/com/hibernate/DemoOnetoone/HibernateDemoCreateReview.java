package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class HibernateDemoCreateReview {
	
	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .addAnnotatedClass(Review.class)
				               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course course =new Course("Data structure");
			
			Review review1=new Review("Very good course");
			Review review2=new Review("This is foundation for any algorithm");
			Review review3=new Review("A very good foundation for any student to crack data structure");
			Review review4=new Review("Very well explained");

			//add some reviews
			course.add(review1);
			course.add(review2);
			course.add(review3);
			course.add(review4);
			
			//print the reviews
			System.out.println("Printing all the reviews"+course.getReviews());
			
			//print the course
			System.out.println("Printing the course"+course);
			
			//save the course	
			session.save(course);
			
			//commit the transaction
			session.getTransaction().commit();
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
		
				
	}

}
