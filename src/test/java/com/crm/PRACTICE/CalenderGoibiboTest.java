package com.crm.PRACTICE;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

public class CalenderGoibiboTest {
	
	@Test
	public void calednder() {
	
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
		String time = date[3].replace(":","-");
		String year = date[5];
		
	String monthYear = mon+" "+year;
	System.out.println(monthYear);
	
	
	/*WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.goibibo.com/");

	
	driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
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
	
	driver.findElement(By.xpath("//span[text()='Done']")).click();*/
	
	}

}
