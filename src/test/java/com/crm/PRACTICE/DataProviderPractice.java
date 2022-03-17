package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	
	
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String Name, String Model, int qty) {
		
		System.out.println(Name+" "+Model+" "+qty);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj = new Object[4][3];
		
		obj[0][0] = "Mi";
		obj[0][1] = "11 pro max";
		obj[0][2] = 30;
		
		obj[1][0] = "iPhone";
		obj[1][1] = "11 pro max";
		obj[1][2] = 20;
		
		obj[2][0] = "Vivo";
		obj[2][1] = "15y max";
		obj[2][2] = 30;
		
		obj[3][0] = "Samsung";
		obj[3][1] = "Galaxy S22";
		obj[3][2] = 15;
		
		return obj;
		
		
	}
	

}
