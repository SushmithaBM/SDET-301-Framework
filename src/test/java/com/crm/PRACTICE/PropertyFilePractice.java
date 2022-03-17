package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	
	@Test
	public void propertyFile() throws Throwable
	{
		
		//Step1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step2: Create Obj of Properties
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//Step3: read the data 
		String URL = pObj.getProperty("url");
		
		//Verification
		System.out.println(URL);
	}

}
