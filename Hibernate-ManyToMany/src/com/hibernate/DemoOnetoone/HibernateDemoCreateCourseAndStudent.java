package com.hibernate.DemoOnetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class HibernateDemoCreateCourseAndStudent {
	
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
			
			//create a course
			Course course =new Course("Data Science");
			
			//save the course	
			session.save(course);
			
			//print the Courses
			System.out.println("Printing all the reviews"+course);
			
			//create the students
		    Student student=new Student("Akhil","sharma","malladiakhilsharma@gmail.com");
			Student student1=new Student("Abhishek","Veery","veeryAbhisek@gmail.com");
            Student student2=new Student("Nowsahd","Sheik","Nowshadbalu@gmail.com");
			Student student3=new Student("Akshay","Kola","akshaykolareddy@gmail.com");

			course.add(student);
			course.add(student1);
			course.add(student2);
			course.add(student3);
		
			//save students
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//print the all the students that are associated with the course
			System.out.println("Printing the course"+course.getStudents());
			
			
			
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
