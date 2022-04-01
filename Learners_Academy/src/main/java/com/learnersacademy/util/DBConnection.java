package com.learnersacademy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con = null;
	
	public static Connection getConnection()
	{
		if(con == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "zeyan","zeyan");
				System.out.println("connection success");
		   }
		   catch (Exception e) 
		   { 
			   e.printStackTrace();
		   }
		}
		
		
		return con;
	}

}
