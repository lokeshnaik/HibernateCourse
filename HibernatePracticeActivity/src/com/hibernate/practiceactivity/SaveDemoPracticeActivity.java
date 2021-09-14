package com.hibernate.practiceactivity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.entity.Employee;



public class SaveDemoPracticeActivity {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		Employee employee=new Employee(1,"Lokesh","Naik","Mphasis");
		
        try
        {
        	//create transaction
           session.beginTransaction();
           
           //saving in the database
           session.save(employee);
           
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
