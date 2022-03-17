package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.util.Properties;
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
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithNotifyEnabledTest {
	
	
	@Test
	public void createContactWithNotifyEnabled() throws Throwable{
		
			
			/*Step 1: read all neccessary data*/
			//read data from property file
			/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);*/
			WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
		
			PropertyFileUtility pLib = new PropertyFileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			ExcelFileUtility eLib = new ExcelFileUtility();
		
		
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			
			//read data from excel sheet
			/*FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Contact");
			Row ro = sh.getRow(3);
			Cell cel = ro.getCell(2);
			String firstName = cel.getStringCellValue();
			
			Cell cel1 = ro.getCell(3);
			String lastName = cel1.getStringCellValue();*/
			
			String firstName = eLib.readDataFromExcel("Contact", 3, 2)+"_"+jLib.getRandomNumber();
			String lastName = eLib.readDataFromExcel("Contact", 3, 3);
			
			
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
			/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			
			/*Step 4: Navigate to Contacts Link*/
			/*driver.findElement(By.linkText("Contacts")).click();*/
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			/*Step 5: click on create contact btn*/
			//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactImg();
			
			/*Step 6: enter mandatory fields and save*/
			/*driver.findElement(By.name("firstname")).sendKeys(firstName);
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			Step 7: making notify owner enabled
			driver.findElement(By.name("notify_owner")).click();*/
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createContactenableNotifyOwnerCheckBox(lastName);
			
			/*Step 8: Logout*/
			/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
			hp.signOutOfApp(driver);
	}

}
