package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class HibernateDemoGetCourseAndStudent {
	
	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .addAnnotatedClass(Review.class)
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
			int id=7;
			
			Course course=session.get(Course.class, id);
			
			//Print all the Course object
			System.out.println("Print the couse="+course);
			
			//Print all the students associated with the given course
			System.out.println("Print the couse="+course.getStudents());

			
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
