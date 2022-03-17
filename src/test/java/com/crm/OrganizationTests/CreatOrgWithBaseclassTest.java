package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;


@Listeners(com.crm.GenericLibrary.ListenersImplementationClass.class)
public class CreatOrgWithBaseclassTest extends BaseClass{
	
	
	@Test(groups="smokeSuite")
	public void createOrgWithBaseclass() throws Throwable {
		
		
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
		
		/*Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Assert.fail();
		
		
		/*click on create organization btn*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*enter mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		/*Verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgNameInfo = oip.OrgNameInfo();
		if(OrgNameInfo.contains(OrgName)) {
			
			System.out.println(OrgNameInfo+" ------> data verified");
		}
		else {
			
			System.out.println("data invalid");
		}
		}
	
		/*@Test(groups="regressionSuite")
		public void xyz() {
			
			System.out.println("executed TestScript2");
		}*/

}
