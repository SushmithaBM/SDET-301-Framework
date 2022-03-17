package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		
		try {
		//Step1: register the database
        Driver driverRef = new Driver();
        DriverManager.registerDriver(driverRef);
        
        //Step2: get connector from database - provide db name
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
        System.out.println("Connection Established");
        
        //Step3: issue create statement
        Statement stat = con.createStatement();
        
        //Step4: Execute a query
        int result = stat.executeUpdate("insert into student values(10,'Iha','Female');");
        System.out.println(result);
        if(result == 1)
        {
         System.out.println("data added successfully");
        }
        else
        {
        	System.out.println("data not added");
        }
		}
		
		catch(Exception e) {}
		
        finally {
        //Step5: close the database
        con.close();
        System.out.println("Connection Closed");
        }
	}

}
