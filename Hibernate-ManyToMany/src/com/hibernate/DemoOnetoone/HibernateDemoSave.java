package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoSave {

	public static void main(String[] args)
	{
		SessionFactory factory =new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();	

		//create session object
		Session session=factory.getCurrentSession();

		try
		{
			//create the objects
			Instructor instructor=new Instructor("Akhil","Sharma","akhilmalladhi@gmail.com");

			InstructorDetail instructordetail=new InstructorDetail("https://cinema/akhil","Cinema,Stcks investment");

			instructor.setInstructordetail(instructordetail);

			//create the transaction
			session.beginTransaction();

			//saving in the data base
			//session.save(instructor);

			//This will also save instructordetail object
			//because of CasecaseType.ALL
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
