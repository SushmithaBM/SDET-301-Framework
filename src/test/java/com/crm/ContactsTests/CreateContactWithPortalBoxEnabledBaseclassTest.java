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
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithPortalBoxEnabledBaseclassTest extends BaseClass{
	
	@Test
	public void createContactWithPortalBoxEnabled() throws Throwable {
		
		
		//String firstName = eLib.readDataFromExcel("Contact", 3, 2)+"_"+jLib.getRandomNumber();
		String lastName = eLib.readDataFromExcel("Contact", 3, 3);
		String email = eLib.readDataFromExcel("Contact", 3, 4);
		
		
		/*Navigate to Contacts Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		/*click on create contact btn*/
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(lastName,email);

	}


}
