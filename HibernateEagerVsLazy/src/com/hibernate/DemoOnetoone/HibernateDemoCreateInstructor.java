package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoCreateInstructor {

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
			//create the objects
			Instructor instructor=new Instructor("Abhishek","Veery","veeryabhishek@gmail.com");

			InstructorDetail instructordetail=new InstructorDetail("https://travelling/veeryabhishek","Travelling,Gym");

			instructor.setInstructordetail(instructordetail);

			//create the transaction
			session.beginTransaction();

			//saving in the data base
			//session.save(instructor);

			//This will also save instructordetail object
			//because of CasecaseType.ALL
			//save the instructor
			session.save(instructor);

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
