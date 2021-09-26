package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class HibernateDemoDeleteReviewCourse {
	
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
			
			int id=4;
			Course course=session.get(Course.class, id);
			
			//Print the course details
			System.out.println("Printing the couse details="+course);
			
			//Print the reviews
			System.out.println("Printing all the reviews="+course.getReviews());
			
			//delete the course
			session.delete(course);
			
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
