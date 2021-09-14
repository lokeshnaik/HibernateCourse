package com.hibernate.Demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class HibernateDemoRetrievingAllObjects {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
				               
		
		try
		{
			Student stud1=new Student();
			
		    Session session=factory.getCurrentSession();
		    
		    //start transaction
		    session.beginTransaction();
		    
		    List<Student>stud2=session.createQuery("from Student s where s.firstName='Sai' AND  s.lastName='kiran1'").getResultList();
		    
		    System.out.println(stud2);
		    
		    session.getTransaction().commit();
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		
		finally
		{
			factory.close();
		}

	}

}
