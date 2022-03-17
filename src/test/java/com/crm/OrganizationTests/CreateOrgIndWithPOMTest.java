package com.crm.OrganizationTests;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgIndWithPOMTest {
	
	@Test
	public void createOrgIndWithPOM() throws Throwable{
	
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
		String OrgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String IndType = eLib.readDataFromExcel("Org", 4, 3);
		
		
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
		
		/*Step 6: create Org with Ind type*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, IndType);
		
		/*Step 7: Verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgNameInfo = oip.OrgNameInfo();
		if(OrgNameInfo.contains(OrgName)) {
			
			System.out.println(OrgNameInfo+" ------> data verified");
		}
		else {
			
			System.out.println("data invalid");
		}
		
		
		/*Step 9: logout of application*/
		hp.signOutOfApp(driver);
		
		/*Step 10: close the browser*/
		driver.quit();
	}


}
