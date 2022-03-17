package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrgAssertionTest extends BaseClass{
	
	@Test
	public void createOrgWithAssertions() throws Throwable {
		
		
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
		SoftAssert sa = new SoftAssert();
		
		
		/*Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		String ExpData = "Organizations";
		String actData = driver.findElement(By.linkText("Organizations")).getText();
		System.out.println("Execution1");
		Assert.assertEquals(actData, ExpData);
		
		
		/*click on create organization btn*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		String expHeader = "Creating New Organization";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println("Execution2");
		sa.assertEquals(actHeader, expHeader);
		
		
		/*enter mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		/*Verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgNameInfo = oip.OrgNameInfo();
		Assert.assertTrue(OrgNameInfo.contains(OrgName));
		Reporter.log(OrgNameInfo+"org created", true);
		System.out.println("Execution3");
		sa.assertTrue(OrgNameInfo.contains(OrgName));
		
		System.out.println("Passed");
		sa.assertAll("all ok");
		
		/*if(OrgNameInfo.contains(OrgName)) {
			
			System.out.println(OrgNameInfo+" ------> data verified");
		}
		else {
			
			System.out.println("data invalid");
		}*/
		
		}

}
