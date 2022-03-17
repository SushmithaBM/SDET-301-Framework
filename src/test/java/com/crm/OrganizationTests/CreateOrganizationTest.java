package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {

	@Test
	public void createOrganizationTest(){
		
		//Step1: launch browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//Step2: Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3: navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step4: click on organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step5: create org with mandatory feilds
		driver.findElement(By.name("accountname")).sendKeys("All states");
		
		//Step6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
	}
	
}
