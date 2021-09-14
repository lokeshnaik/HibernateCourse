package com.hibernate.practiceactivity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.entity.Employee;


public class RetriveDemoParctice {

	public static void main(String[] args) {
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

//saving in the database
List<Employee> employee=session.createQuery("from Employee").getResultList();

//Printing all the available employees
//System.out.println(employee);

int empid=0;
//finding for employee whose  lastName='Kola'
for(Employee emp:employee)
{
	if(emp.getLastName().compareTo("Kola")==0)
	{
		empid=emp.getEmployeeId();
	}
}

Employee emp=session.get(Employee.class,empid);

//Printing output of employee whose lastName='Kola'
System.out.println(emp);

//commit transaction
session.getTransaction().commit();

}
catch(Exception exe)
{
exe.printStackTrace();
}

finally
{
//closing factory object
factory.close();
}


	}

}
