package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXMLfileTest {
	
	@Test
	public void readDataFromXML(XmlTest xml) {
		
		String BROWSER = xml.getParameter("browser");
		String URL = xml.getParameter("url");
		
		System.out.println(BROWSER);
		System.out.println(URL);
	}

}
