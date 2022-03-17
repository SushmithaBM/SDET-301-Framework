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

public class CreateCampaignWithProductTest {
	
	@Test
	public void createCampaignWithProductTest() throws Throwable {
		
		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		/*Step 1: read all neccessary data*/
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel sheet
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Campaign");
				Row ro = sh.getRow(1);
				Cell cel = ro.getCell(2);
				String productName = cel.getStringCellValue();
				String productNameRan=productName+" "+random;
		
		
				Cell ce = ro.getCell(3);
				String campaignName = ce.getStringCellValue()+random;
				
				
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
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
				driver.findElement(By.name("productname")).sendKeys(productNameRan);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				/*Step 7:verify for product*/
				String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
				if(header.contains(productNameRan))
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
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(ele));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				
				
				
				Set<String> more = driver.getWindowHandles();
				for(String winId:more)
				{
					driver.switchTo().window(winId);
				}
				driver.findElement(By.linkText("Campaigns")).click();
				
				
				Set<String> win11 = driver.getWindowHandles();
				for(String wi : win11)
				{
					driver.switchTo().window(wi);
				}
				
				
				/*Step 9: Create Campaign*/
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				
				/*Step 10: enter mandatory fields*/
				driver.findElement(By.name("campaignname")).sendKeys(campaignName);
				
				/*Step 11: Product*/
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				/*Step 12: choose Product */
				Set<String> win = driver.getWindowHandles();
				for(String winId:win)
				{
					driver.switchTo().window(winId);
				}
				
				driver.findElement(By.id("search_txt")).sendKeys(productNameRan);
				driver.findElement(By.name("search")).click();
				
				driver.findElement(By.xpath("//a[text()='"+productNameRan+"']")).click();
				
				Set<String> win1 = driver.getWindowHandles();
				for(String wi : win1)
				{
					driver.switchTo().window(wi);
				}
				
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
				Actions act1 = new Actions(driver);
				act1.moveToElement(element).perform();				
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();
				
				
				
	}

}
