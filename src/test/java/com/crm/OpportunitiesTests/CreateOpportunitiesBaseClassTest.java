package com.crm.OpportunitiesTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
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

public class CreateOpportunitiesBaseClassTest extends BaseClass{
	
	@Test
	public void createOpportunities() throws Throwable {
		
		//read data from excel sheet
		String lastName = eLib.readDataFromExcel("Opportunities", 1, 3)+"_"+jLib.getRandomNumber();
		String campaignName = eLib.readDataFromExcel("Opportunities", 1, 4);
		String opportunityName = eLib.readDataFromExcel("Opportunities", 1, 2);
		String leadSource =eLib.readDataFromExcel("Opportunities", 1, 5);
	
		
		/*Create contact*/
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		/*Click on Contact Img*/
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactImg();
		
		/*Create Contact*/
		CreateContactPage cc = new CreateContactPage(driver);
		cc.createNewContact(lastName);
		
		/*verify for Contact*/
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
		
		/*Create campaign*/
		hp.clickOnMoreLink();
		hp.clickOnCampaignLink();
		
		CampaignsPage cp1 = new CampaignsPage(driver);
		cp1.clickOnCampaignsLookUpImg();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createNewCampaign(driver, campaignName);
		
		/*Verify Campaign*/
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
		
		/*Navigate to Opportunities */
		hp.clickOnOpportunitiesLink();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnOpportunityLookUpImg();
		
		/*Enter mandatory fields*/
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.createOpportunity(driver, opportunityName, lastName, campaignName, leadSource);
		
		/*Verify Opportunity*/
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
			
	}
	
}
