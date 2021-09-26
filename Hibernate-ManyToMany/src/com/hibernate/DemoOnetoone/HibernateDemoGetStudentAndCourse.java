package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class HibernateDemoGetStudentAndCourse {
	
	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .addAnnotatedClass(Review.class)
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
			int id=8;
			
			Student student=session.get(Student.class, id);
			
			//Print all the Student object
			System.out.println("Print the couse="+student);
			
			//Print all the course associated with the given student id
			System.out.println("Print the couse="+student.getCourses());

			
			//commit the transaction
			session.getTransaction().commit();
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
		
				
	}

}
