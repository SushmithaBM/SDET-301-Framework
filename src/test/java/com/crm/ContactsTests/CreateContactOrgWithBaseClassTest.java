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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateContactOrgWithBaseClassTest extends BaseClass{
	
	@Test
	public void createContactOrg() throws Throwable {
		
		
		    //read data from excel sheet
			String lastName = eLib.readDataFromExcel("Contact", 6, 2);
			int ran = jLib.getRandomNumber();
			String OrgName = eLib.readDataFromExcel("Contact", 6, 4)+ran;
			
			
			/* Navigate to Organizations Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
			
			/* click on create organization btn*/
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgImg();
			
			/* create Organization*/
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
			
			/* Create Contact*/
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
	
   }


}
