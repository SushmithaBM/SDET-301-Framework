package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will read data from property file and return value to user
 * @author sushmitha
 *
 */
public class PropertyFileUtility {
	
	
	/**
	 * This method will read data from property file for the key given and return value to user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	 public String readDataFromPropertyFile(String key) throws Throwable{
		 
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		 Properties pLib =  new Properties();
		 pLib.load(fis);
		 String value = pLib.getProperty(key);
		 return value;
		 
		 
	 }
	
	

}
