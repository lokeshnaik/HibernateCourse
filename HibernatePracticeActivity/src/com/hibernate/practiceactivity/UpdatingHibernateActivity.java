package com.hibernate.practiceactivity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.entity.Employee;

public class UpdatingHibernateActivity {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .buildSessionFactory();
		
		//creating session object
		Session session=factory.getCurrentSession();
		
		
        try
        {
        	//create transaction
           session.beginTransaction();
           
        //   Query for updating using lastName  
        //   session.createQuery("update Employee set lastName='Kola Reddy' where lastName='Kola'").executeUpdate();
           
      List<Employee> emp=session.createQuery("from Employee").getResultList();
      
      //Updating employee lastName='Sheik' to lastName='SheikMd'
      for(Employee employee: emp)
      {
    	  if((employee.getFirstName()).compareTo("Nowshad")==0)
    	  {
    		 employee.setLastName("SheikMd");
       	     break;
    	  }

      }
      
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
