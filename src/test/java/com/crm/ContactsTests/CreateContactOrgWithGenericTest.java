package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.util.Properties;
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

public class CreateContactOrgWithGenericTest {

	@Test
	public void createContactOrgWithGenericTest() throws Throwable {
		
		
	
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
			String lastName = eLib.readDataFromExcel("Contact", 1, 3);
		
		
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
			
			
			/*Step 4: Navigate to Organizations Link*/
			driver.findElement(By.linkText("Contacts")).click();
			
			/*Step 5: click on create organization btn*/
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			/*Step 6: enter mandatory fields and save*/
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			/*Step 7: Choose the existing organization*/
			driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();

			wLib.switchTowindow(driver, "Accounts");
			driver.findElement(By.id("1")).click();
			wLib.switchTowindow(driver, "Contacts");
		    
			
			/*Step 8: Save*/
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 9: logout of application*/
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mouseHover(driver, ele);
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			/*Step 8: close the browser*/
			driver.quit();
   }
}
