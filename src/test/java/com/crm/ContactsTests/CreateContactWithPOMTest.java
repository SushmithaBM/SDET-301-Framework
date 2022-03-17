package com.crm.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateContactWithPOMTest {
	

	@Test
	public void createContactOrgWithGenericTest() throws Throwable {
		
		
	
			PropertyFileUtility pLib = new PropertyFileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			ExcelFileUtility eLib = new ExcelFileUtility();
		
			
			/*Step 1: read all neccessary data*/
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		    //read data from excel sheet
			String lastName = eLib.readDataFromExcel("Contact", 1, 3);
		
		
			/*Step 2: launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
	
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
			
			/*Step 3: login to application*/
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			
			/*Step 4: Navigate to Contact Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			/*Step 5: click on create organization btn*/
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactImg();
			
			
			/*Step 6: enter mandatory fields and save*/
			CreateContactPage cop = new CreateContactPage(driver);
			cop.createNewContact(lastName);
		    
			
			/*Step 7: Verification*/
			ContactInfoPage oip = new ContactInfoPage(driver);
			String contactNameInfo = oip.lastNameInfo();
			if(contactNameInfo.contains(lastName)) {
				
				System.out.println(contactNameInfo+" ------> data verified");
			}
			else {
				
				System.out.println("data invalid");
			}
			/*Step 8: logout of application*/
			hp.signOutOfApp(driver);
			
			/*Step 9: close the browser*/
			driver.quit();
   }

}
