package com.crm.OpportunitiesTests;

import java.util.Set;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunitiesTest {
	
	@Test
	public void createOpportunities() throws Throwable {
		
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
		
		/*Step 4 : Create contact*/
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5:verify for Contact*/
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
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
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 7 : Verify Campaign*/
		String campHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
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
		
		/*Step 7 : Navigate to Opportunities */
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		/*Step 8 : Enter mandatory fields*/
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		
		/*Step 9  : Choose Contacts in "Related To" dropdown*/
		WebElement ele = driver.findElement(By.id("related_to_type"));
		wLib.select(ele, "Contacts");
		
		/*Step 10 : Choose Contact from window*/
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@alt='Select']")).click();
		wLib.switchTowindow(driver, "Contacts");
		driver.findElement(By.id("search_txt")).sendKeys(lastName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+lastName+"')]")).click();
		wLib.switchTowindow(driver, "Potentials");
		
		/*Step 11 : Choose employee from lead source dropdown*/
		WebElement ls = driver.findElement(By.name("leadsource"));
		wLib.select(ls, "Employee");
		
		/*Step 12 : Select Campaign from campaign source window*/
		driver.findElement(By.xpath("//input[@name='campaignid']/following-sibling::img[@alt='Select']")).click();
		wLib.switchTowindow(driver, "Campaigns");
		driver.findElement(By.id("search_txt")).sendKeys(campaignName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		wLib.switchTowindow(driver, "Potentials");
		
		/*Step 13 : Selecting date from date*/
		driver.findElement(By.id("jscal_trigger_closingdate")).click();
		
		/*Step 13 : Save Opportunity*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 14 : Verify Opportunity*/
		String oppHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
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
		
		/*Step 15 : Logout */
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, element);				
		driver.findElement(By.linkText("Sign Out")).click();
			
	}
	
}
