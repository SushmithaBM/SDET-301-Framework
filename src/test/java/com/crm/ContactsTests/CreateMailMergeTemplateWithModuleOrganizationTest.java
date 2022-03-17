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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/*TC_34*/

public class CreateMailMergeTemplateWithModuleOrganizationTest {
	
	@Test
	public void createMailMergeTemplateWithModuleOrganization() throws Throwable{
		
	
			
			/*Step 1: read all neccessary data*/
			//read data from property file
			/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");*/
		
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
			Row ro = sh.getRow(0);
			Cell cel = ro.getCell(2);
			String Module = cel.getStringCellValue();*/
			String Module = eLib.readDataFromExcel("Contact", 0, 2);
			
			
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
			//driver.findElement(By.linkText("Contacts")).click();
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			
			/*Step 6: click on create mail merge template link*/
			//driver.findElement(By.xpath("//a[contains(text(),'Create Mail Merge templates ')]")).click();
			
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.clickOnMailMerge();
			ccp.createMailMerge();
			
			hp.signOutOfApp(driver);
			
			
			
			/*Step 7: Click on Choose Files
			
			WebElement e = driver.findElement(By.name("binFile"));
			e.sendKeys("C:\\Users\\sushmitha\\Desktop\\D\\Resume\\SUSHMITHA_BM_CV.doc");
			System.out.println("File uploaded successfully");
			
			
			/*Step 8: Select Organization
			WebElement drpdwn = driver.findElement(By.name("target_module"));
			Select s = new Select(drpdwn);
			s.selectByValue("Accounts");
			
			Step 9: click on save
			driver.findElement(By.xpath("//input[@title='Save']")).click();*/
			
			/*Step 9: Logout*/
			/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
			
			
			
			
			
			
	}

}
