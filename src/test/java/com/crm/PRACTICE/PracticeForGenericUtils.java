package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils{
	
	@Test
	public void practice() throws Throwable{

		
		//Java Utility
		JavaUtility jLib = new JavaUtility();
		int ran = jLib.getRandomNumber();
		String dat = jLib.getSystemDateInFormat();
		String date = jLib.getSystemDate();
		System.out.println(ran+" "+date);
		System.out.println(dat);
		
		//Property File Utility
		PropertyFileUtility pLib = new PropertyFileUtility();
		String brows = pLib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		
		//Excel File Utility
		ExcelFileUtility eLib = new ExcelFileUtility();
		String value = eLib.readDataFromExcel("Org",3,2);
		System.out.println(value);
		
		
		
	}
	
	

}
