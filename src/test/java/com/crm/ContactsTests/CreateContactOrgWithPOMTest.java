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

public class CreateContactOrgWithPOMTest {
	
	@Test
	public void createContactOrgWithPOM() throws Throwable {
		
		
	
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
			String lastName = eLib.readDataFromExcel("Contact", 6, 2);
			int ran = jLib.getRandomNumber();
			String OrgName = eLib.readDataFromExcel("Contact", 6, 4)+ran;
		
		
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
			
			
			/*Step 4: Navigate to Organizations Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
			
			/*Step 5: click on create organization btn*/
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgImg();
			
			/*Step 6: create Organization*/
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(OrgName);
			
			//Verification
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgNameInfo = oip.OrgNameInfo();
			if(OrgNameInfo.contains(OrgName)) {
				
				System.out.println(OrgNameInfo+" ------> data verified");
			}
			else {
				
				System.out.println("data invalid");
			}
			
			/*Step 7: Create Contact*/
			hp.clickOnContactLink();
			
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactImg();
			
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createNewContact(driver, lastName, OrgName);
			
			
			//Verification
			
			ContactInfoPage cip = new ContactInfoPage(driver);
			String lastNameInfo = cip.lastNameInfo();
			if(lastNameInfo.contains(lastName)) {
				
				System.out.println(lastNameInfo+" ------> data verified");
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
