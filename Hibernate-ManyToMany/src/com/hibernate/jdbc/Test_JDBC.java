package com.hibernate.jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test_JDBC {

	public static void main(String[] args)
	{
		  Connection connection = null;
		String database="hibernate";
		String jdbcUrl="jdbc:mysql://localhost:3306/"+database;
		String user="root";
		String password="lokesh";
		try
		{
			   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to databases"+jdbcUrl);
			
			 connection=
					DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection successful");
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
 
	}

}
