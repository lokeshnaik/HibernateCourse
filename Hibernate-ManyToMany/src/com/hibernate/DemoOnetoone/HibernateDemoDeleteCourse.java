package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoDeleteCourse {

	public static void main(String[] args)
	{
		SessionFactory factory =new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();	

		//create session object
		Session session=factory.getCurrentSession();

		try
		{
			//start the transaction
			session.beginTransaction();

		    int id=3;
		    //create the course object
		    Course course=session.get(Course.class,id);
		    
		   //Printing the course that is deleted
		    System.out.println("Deleted that given course="+course);
		    
		   //deleting the course that is associated with given course id
		    session.delete(course);

			//commit the transaction
			session.getTransaction().commit();

		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}

		finally
		{
			session.close();
			factory.close();
		}
	}
}
