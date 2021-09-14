package com.hibernate.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class HibernateDemoRetrive {

	public static void main(String[] args)
	{		
		SessionFactory factory= new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();

		try
		{
			//create a student object
			Student stud=new Student();
			
			Session session=factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			Student stude=session.get(Student.class,1);
			
			System.out.println(stude);
			//commit transaction
			session.getTransaction().commit();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally
		{
			//session.close();
			factory.close();
		}
	}

}
