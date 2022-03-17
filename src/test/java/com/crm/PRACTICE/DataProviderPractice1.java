package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {
	
	@Test(dataProvider = "getData" )
	public void sampleDataProvider(String laptop, int price) {
		
		System.out.println(price+" "+laptop);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj = new Object[6][2];
		
		obj[0][0] = "Lenovo";
		obj[0][1] = 60000;
		
		obj[1][0] = "MacBook";
		obj[1][1] = 120000;
		
		obj[2][0] = "Dell";
		obj[2][1] = 35000;
		
		obj[3][0] = "Acer";
		obj[3][1] = 40000;
		
		obj[4][0] = "HP";
		obj[4][1] = 50000;
		
		obj[5][0] = "Asus";
		obj[5][1] = 40000;
		
		return obj;
		
	}

}
