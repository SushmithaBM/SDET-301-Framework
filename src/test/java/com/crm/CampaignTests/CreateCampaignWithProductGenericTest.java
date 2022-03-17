package com.crm.CampaignTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductGenericTest {
	
	@Test
	public void createCampaignWithProductGenericTest() throws Throwable {
		
		
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
			String prodName = eLib.readDataFromExcel("Campaign", 1, 2);
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
				
				/*Step 3: login to application*/
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				/*Step 4: Navigate to Product*/
				driver.findElement(By.linkText("Products")).click();
				
				/*Step 5: Create a Product*/
				driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
				
				/*Step 6: enter mandatory fields and save*/
				driver.findElement(By.name("productname")).sendKeys(prodName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				/*Step 7:verify for product*/
				String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
				if(header.contains(prodName))
				{
					System.out.println(header);
					System.out.println("product created");
				}
				else
				{
					System.out.println(header);
					System.out.println("product not created");
				}
				
		
				/*Step 8: Navigate to Campaign*/
				driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();

				Set<String> more = driver.getWindowHandles();
				for(String winId:more)
				{
					driver.switchTo().window(winId);
				}
				
				driver.findElement(By.linkText("Campaigns")).click();
				wLib.switchTowindow(driver,"Campaigns");
				
				
				/*Step 9: Create Campaign*/
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				
				/*Step 10: enter mandatory fields*/
				driver.findElement(By.name("campaignname")).sendKeys(campaignName);
				
				/*Step 11: Product*/
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				/*Step 12: choose Product */
				wLib.switchTowindow(driver, "Products");
				driver.findElement(By.id("search_txt")).sendKeys(prodName);
				driver.findElement(By.name("search")).click();
				
				driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
				
			
				wLib.switchTowindow(driver, "Campaigns");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				/*Step 13: verify for campaign*/
				String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(campaignHeader.contains(campaignName))
				{
					System.out.println(campaignHeader +" campaign created");
				}
				else
				{
					System.out.println("campaign not created");
				}
				
				/*Step 14: logout and close the browser*/
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wLib.mouseHover(driver, element);				
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();
			
				
	}

}
