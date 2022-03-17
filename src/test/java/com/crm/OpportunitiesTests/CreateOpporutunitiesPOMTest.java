package com.crm.OpportunitiesTests;

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
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOpportunitiesPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitiesInfoPage;
import com.crm.ObjectRepository.OpportunitiesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpporutunitiesPOMTest {
	
	@Test
	public void createOpportunitiesPOM() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	
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
		String lastName = eLib.readDataFromExcel("Opportunities", 1, 3)+"_"+jLib.getRandomNumber();
		String campaignName = eLib.readDataFromExcel("Opportunities", 1, 4);
		String opportunityName = eLib.readDataFromExcel("Opportunities", 1, 2);
		String leadSource =eLib.readDataFromExcel("Opportunities", 1, 5);
		
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
		
		/*Step 4 : Create contact*/
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactImg();
		CreateContactPage cc = new CreateContactPage(driver);
		cc.createNewContact(lastName);
		
		/*Step 5:verify for Contact*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.lastNameInfo();
		if(header.contains(lastName))
		{
			System.out.println(header);
			System.out.println("Contact created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Contact not created");
		}
		
		/*Step 6 : Create campaign*/
		hp.clickOnMoreLink();
		hp.clickOnCampaignLink();
		
		CampaignsPage cp1 = new CampaignsPage(driver);
		cp1.clickOnCampaignsLookUpImg();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createNewCampaign(driver, campaignName);
		
		/*Step 7 : Verify Campaign*/
		CampaignInfoPage cip1 = new CampaignInfoPage(driver);
		String campHeader = cip1.campaignNameInfo() ;
		if(campHeader.contains(campaignName))
		{
			System.out.println(header);
			System.out.println("Campaign created");
		}
		else
		{
			System.out.println(campHeader);
			System.out.println("Campaign not created");
		}
		
		/*Step 8 : Navigate to Opportunities */
		hp.clickOnOpportunitiesLink();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnOpportunityLookUpImg();
		
		/*Step 9 : Enter mandatory fields*/
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.createOpportunity(driver, opportunityName, lastName, campaignName, leadSource);
		
		/*Step 10 : Verify Opportunity*/
		OpportunitiesInfoPage oip = new OpportunitiesInfoPage(driver);
		String oppHeader = oip.opportunityNameInfo();
		if(oppHeader.contains(opportunityName))
		{
			System.out.println(header);
			System.out.println("Opportunity created");
		}
		else
		{
			System.out.println(campHeader);
			System.out.println("Opportunity not created");
		}
		
		/*Step 11 : Logout */
		hp.signOutOfApp(driver);
			
	}
	

}
