package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class HibernateDemoGetInstructorDetail {

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
		   
			int id=4;
			
			InstructorDetail instructordetail=session.get(InstructorDetail.class,id);
            //print the instructor detail object
			System.out.println("instructordetail="+instructordetail);
            
            //print the associated instructor
            System.out.println("The associated istructor="+instructordetail.getInstructor());

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
