package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoDelete {

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

			//create the transaction
			session.beginTransaction();
			
			int id=1;
			
			//get by primary key
			Instructor instructor=session.get(Instructor.class, id);
			
			if(instructor!=null)
			{
	          System.out.println("We are deleting object whose id is="+id);
			
			    session.delete(instructor);
			}
			else
			{
				System.out.println("We dont have id with that primary key");
			}
			
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
