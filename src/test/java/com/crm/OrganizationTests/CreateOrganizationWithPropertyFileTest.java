package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationWithPropertyFileTest {

	
	@Test
	public void propertyFile() throws Throwable{
		
		//Step1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//eg for runtime polymorphism
		WebDriver driver = null;
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
			System.out.println("Invalid ");
		}
		
		//Step1: launch browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL);
				
				//Step2: Login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step3: navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step4: click on organization link
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step5: create org with mandatory feilds
				driver.findElement(By.name("accountname")).sendKeys("ABC");
				
				//Step6: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				driver.quit();
	}
}
