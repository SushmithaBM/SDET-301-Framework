package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		//Create Obj for all utilities
		public PropertyFileUtility pLib = new PropertyFileUtility();
		public ExcelFileUtility eLib = new ExcelFileUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public JavaUtility jLib = new JavaUtility();
		public DatabaseUtility dLib = new DatabaseUtility();
		public WebDriver driver = null;
		public static WebDriver sDriver;
		
		@BeforeSuite(groups={"smokeSuite","regressionSuite"})
		public void connectDataBase() throws Throwable{
			
			//dLib.connectToDb();
			Reporter.log("======db connection successful======",true);
		}
		
		@BeforeClass(groups={"smokeSuite","regressionSuite"})
		//@Parameters("browser")
		//@BeforeTest
		public void launchTheBrowser() throws Throwable{
			
			//read data from property
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			
			//Create runtime polymorphism
			if(BROWSER.equalsIgnoreCase("Chrome")) {
				
				//WebDriverManager.chromedriver.setup();
				driver = new ChromeDriver();
				System.out.println("Chrome browser");
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("FireFox browser");
			}
			else
			{
				System.out.println("Invalid browser");
			}
			
			sDriver = driver;
			
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
		}
		
		@BeforeMethod(groups={"smokeSuite","regressionSuite"})
		public void login() throws Throwable{
			
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);
			
		}
		
		@AfterMethod(groups={"smokeSuite","regressionSuite"})
		public void logout() {
			
			HomePage hp = new HomePage(driver);
			hp.signOutOfApp(driver);
			Reporter.log("=====Logout successfull=====",true);
		}
		
		@AfterClass(groups={"smokeSuite","regressionSuite"})
		//@AfterTest
		public void closeBrowser() {
			
			driver.quit();
			Reporter.log("=====browser close successfull=====", true);
		}
		
		@AfterSuite(groups={"smokeSuite","regressionSuite"})
		public void closeDb() {
			
			//dLib.closeDB();
			Reporter.log("=====Database close successful=====",true);
		}
		
}
