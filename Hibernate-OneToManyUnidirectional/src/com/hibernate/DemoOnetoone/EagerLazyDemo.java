package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

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

			//create the transaction
			session.beginTransaction();
		   
			int id=2;
			
			Instructor instructor=session.get(Instructor.class,id);
            //print the instructor  object
			System.out.println("instructordetail="+instructor);
            
            //print the associated courses
            System.out.println("The associated courses="+instructor.getCourses());

			//commit the transaction
			session.getTransaction().commit();

		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}

		finally
		{
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
