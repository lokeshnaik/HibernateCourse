package com.hibernate.practiceactivity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.entity.Employee;

public class DeletinghibernatePractice {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
        try
        {
        	//create transaction
           session.beginTransaction();
           
           session.createQuery("delete from Employee where lastName='loki'").executeUpdate();
           
           //commit transaction
           session.getTransaction().commit();
        	
        }
        catch(Exception exe)
        {
        	exe.printStackTrace();
        }
 
        finally
        {
        	//closing session object
        	session.close();
        	//closing factory object
        	factory.close();
        }
        

	}

}
