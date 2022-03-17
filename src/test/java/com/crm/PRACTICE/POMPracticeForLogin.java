package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPracticeForLogin {
	
	@Test
	public void pomPractice() throws Throwable {
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(pLib.readDataFromPropertyFile("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		hp.signOutOfApp(driver);
		
		
		
	}

}
