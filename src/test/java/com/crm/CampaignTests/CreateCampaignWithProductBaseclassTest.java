package com.crm.CampaignTests;

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
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductBaseclassTest extends BaseClass{
	
	@Test
	public void createCampaignWithProduct() throws Throwable {
	
	    //read data from excel sheet
		String campaignName = eLib.readDataFromExcel("Campaign", 1, 3)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcel("Campaign", 1, 2)+"_"+jLib.getRandomNumber();
		//String catType = eLib.readDataFromExcel("Campaign", 1, 4);
			
			
			/*Navigate to Product Link*/
			HomePage hp = new HomePage(driver);
			hp.clickOnProductsLink();
			
			/*Click on Create product*/
			ProductsPage p = new ProductsPage(driver);
			p.clickOnCreateProductImg();
			
			/*Create Product*/
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
			
			/*More & campaign*/
			hp.clickOnMoreLink();
			hp.clickOnCampaignLink();
			
			//
			CampaignsPage cp = new CampaignsPage(driver);
			cp.clickOnCampaignsLookUpImg();
			
			/* Create campaign*/
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
			
	}

}
