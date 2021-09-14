package com.hibernate.Demo;

import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
			//create a 3 student object
			Student student1=new Student("sai","kiran","saikiran@gmail.com");
			Student student2=new Student("Akshay","kola","akshaykola@gmail.com");
			Student student3=new Student("Nowshad","sheik","nowshad@gmail.com");

			//start transaction
			session.beginTransaction();
			
			//save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("End of session work");
			
		}
		finally
		{
			session.close();
			factory.close();
			
			//entityManager.close();
		}
	}

}

