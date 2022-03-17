package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderGoibiboTrainTest {
	
	@Test
	public void calednder() {
		
	int date = 12;
	String monthYear = "May 2022";
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.goibibo.com/");
	
	Actions action = new Actions(driver);
	action.moveByOffset(10, 10).click().perform();
	
	//Trains link
	driver.findElement(By.xpath("//a[@class='nav-link active']")).click();
	
	String dateXpath = "//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	String arrowXpath = "//span[@aria-label='Next Month']";
	//driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	
	for(;;) {
		
		try {
			
			driver.findElement(By.xpath(dateXpath)).click();
			break;
			
		}
		catch(Exception e) {
			driver.findElement(By.xpath(arrowXpath)).click();
		}
	}
	
	driver.findElement(By.xpath("//span[text()='Done']")).click();
	
	}

}
