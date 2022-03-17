package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgIndTypeWithBaseclassTest  extends BaseClass{
	
	@Test(groups="smokeSuite")
	public void createOrgIndType() throws Throwable{
	
		//read data from excel sheet
		String OrgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String IndType = eLib.readDataFromExcel("Org", 4, 3);
		String Type = eLib.readDataFromExcel("Org",4,4);
		
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		/*Step 5: click on create organization btn*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*Step 6: create Org with Ind type and Type*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, IndType, Type);
		
		/*Step 7: Verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgNameInfo = oip.OrgNameInfo();
		if(OrgNameInfo.contains(OrgName)) {
			
			System.out.println(OrgNameInfo+" ------> data verified");
		}
		else {
			
			System.out.println("data invalid");
		}
		
	}
	
	/*@Test
	public void sample1() {
		
		System.out.println("Sample 1");
	}
	
	@Test
	public void sample2() {
		
		System.out.println("Sample 2");
	}
	
	@Test
	public void sample3() {
		
		System.out.println("Sample 3");
	}*/
	


}
