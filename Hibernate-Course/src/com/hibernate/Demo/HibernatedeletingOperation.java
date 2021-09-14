package com.hibernate.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class HibernatedeletingOperation
{

	public static void main(String arg[])
	{
		SessionFactory factory=new Configuration()
				             .configure("hibernate.cfg.xml")
				             .addAnnotatedClass(Student.class)
				             .buildSessionFactory();
		
		try
		{
			//creating session object
			Session session=factory.getCurrentSession();
			//start the transaction
		
			session.beginTransaction();
			/*session.beginTransaction();
			//stud object is created
			Student stud=new Student("Loki","loki","loki@gmail.com");
			//Saving operation is performed
			session.save(stud);*/
			
			//query for deleting operation
			session.createQuery("delete from Student where StudentId=7").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
	}
	
}
