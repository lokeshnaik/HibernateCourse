package com.hibernate.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class HibernateDemoSave {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		Session session= factory.getCurrentSession();

		try
		{
			System.out.println("Creating new student object");
			//create a student object
			Student student=new Student("Lokesh","naik","naik@gmail.com");
		
			//start transaction
			session.beginTransaction();
			
			//save the student object
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("End of session work");
			
		}
		finally
		{
			factory.close();
		}
	}

}
