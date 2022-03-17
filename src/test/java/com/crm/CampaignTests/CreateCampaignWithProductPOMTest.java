package com.crm.CampaignTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductPOMTest {
	
	@Test
	public void createCampaignWithProductPOM() throws Throwable {
		
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
		String campaignName = eLib.readDataFromExcel("Campaign", 1, 3)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcel("Campaign", 1, 2)+"_"+jLib.getRandomNumber();
		//String catType = eLib.readDataFromExcel("Campaign", 1, 4);
			
			
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
			
			//Step 3: Login
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			/*Step 4: Navigate to Product Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnProductsLink();
			
			/*Step 5: Click on Create product*/
			ProductsPage p = new ProductsPage(driver);
			p.clickOnCreateProductImg();
			
			/*Step 6: Create Product*/
			CreateProductPage cpp = new CreateProductPage(driver);
			cpp.createNewProduct(prodName);
			
			
			//Verification
			ProductInfoPage oip = new ProductInfoPage(driver);
			String proNameInfo = oip.productNameInfo();
			if(proNameInfo.contains(prodName)) {
				
				System.out.println(proNameInfo+" ------> data verified");
			}
			else {
				
				System.out.println("data invalid");
			}
			
			/*Step 7: More & campaign*/
			hp.clickOnMoreLink();
			hp.clickOnCampaignLink();
			
			//
			CampaignsPage cp = new CampaignsPage(driver);
			cp.clickOnCampaignsLookUpImg();
			
			/*Step 8: Create campaign*/
			CreateCampaignPage ccpp = new CreateCampaignPage(driver);
			ccpp.createNewCampaign(driver, campaignName, prodName);
			
			//Verification
			CampaignInfoPage cip = new CampaignInfoPage(driver);
			String campNameInfo = cip.campaignNameInfo();
			if(campNameInfo.contains(campaignName)) {
				
				System.out.println(campNameInfo+" ------> data verified");
			}
			else {
				
				System.out.println("data invalid");
			}
			
			/*Step 9: SignOut*/
			hp.signOutOfApp(driver);
			
			/*Step 10: close browser*/
			driver.quit();
			
		
		
		
	}

}
