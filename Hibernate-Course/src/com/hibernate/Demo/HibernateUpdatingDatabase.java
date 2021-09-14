package com.hibernate.Demo;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class HibernateUpdatingDatabase {

	public static void main(String[] args) 
	{
      
		SessionFactory factory=new Configuration()
                              .configure("hibernate.cfg.xml")
                              .addAnnotatedClass(Student.class)
                              .buildSessionFactory();
		try
		{
			//creating session object
			Session session=factory.getCurrentSession();
			
			//Start transaction
			session.beginTransaction();
			
			List<Student> student=session.createQuery("from Student").getResultList();
			int id=0;
			
			for(Student s: student)
			{
				if(s.getFirstName().compareTo("Akshay")==0)
				{
					id=s.getStudentId();
					
					s.setLastName("Kola Reddy");
					break;
				}
			}
			
			System.out.println("Student id="+ id);
		
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println(student);
			
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}

	}

}
