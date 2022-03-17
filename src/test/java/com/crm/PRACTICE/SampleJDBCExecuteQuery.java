package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {

	//public static void main(String[] args) throws SQLException {
		
		
	@Test
	public void sampleJDBCExecuteQuery() throws Throwable {
		
		//Step1: register the database
        Driver driverRef = new Driver();
        DriverManager.registerDriver(driverRef);
        
        //Step2: get connector from database - provide db name
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
        
        //Step3: issue create statement
        Statement stat = con.createStatement();
        
        //Step4: Execute a query
        ResultSet result = stat.executeQuery("Select * from student;");
        while(result.next())
        {
        	
         System.out.println(result.getString(1)+" " + result.getString(2)+" "+ result.getString(3));
        
        }	
        
        //Step5: close the database
        con.close();
	}
	
	//}

}
