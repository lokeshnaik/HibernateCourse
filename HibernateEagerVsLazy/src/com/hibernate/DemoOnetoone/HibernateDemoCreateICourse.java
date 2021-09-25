package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoCreateICourse {

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

			//get the instructor from database
			int id=2;

			Instructor instructor=session.get(Instructor.class, id);



			//create some courses		
			Course courses=new Course("Microsoft Azure");
			Course courses1=new Course("AWS");
			Course courses2=new Course("C#");

			//add courses to instructor		
			instructor.add(courses);
			instructor.add(courses1);
			instructor.add(courses2);


			//save the courses
			session.save(courses);
			session.save(courses1);
			session.save(courses2);


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
