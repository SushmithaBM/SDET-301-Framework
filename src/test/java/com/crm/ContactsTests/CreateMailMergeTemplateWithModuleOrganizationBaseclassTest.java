package com.crm.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMailMergeTemplateWithModuleOrganizationBaseclassTest extends BaseClass{
	
	@Test
	public void createMailMergeTemplateWithModuleOrganization() throws Throwable{
		
			
			//read data from excel sheet
			String Module = eLib.readDataFromExcel("Contact", 0, 2);
			
			
			/*Navigate to Contacts Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			
			/*click on create mail merge template link*/
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.clickOnMailMerge();
			ccp.createMailMerge();
					
	}


}
