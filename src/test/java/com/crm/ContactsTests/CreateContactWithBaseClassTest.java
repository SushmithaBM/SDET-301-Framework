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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithBaseClassTest extends BaseClass{
	
	@Test
	public void createContactOrgWithGenericTest() throws Throwable {
		
		
		
		    //read data from excel sheet
			String lastName = eLib.readDataFromExcel("Contact", 1, 3);
			
			/* Navigate to Contact Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			/* click on create organization btn*/
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactImg();
			
			
			/* enter mandatory fields and save*/
			CreateContactPage cop = new CreateContactPage(driver);
			cop.createNewContact(lastName);
		    
			
			/* Verification*/
			ContactInfoPage oip = new ContactInfoPage(driver);
			String contactNameInfo = oip.lastNameInfo();
			if(contactNameInfo.contains(lastName)) {
				
				System.out.println(contactNameInfo+" ------> data verified");
			}
			else {
				
				System.out.println("data invalid");
			}
		
   }


}
