package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class LastOrgNameWebTableTest extends BaseClass{
	

	@Test
	public void lastOrgNameWebTable() throws Throwable {
	
	/* Navigate to Contact Link*/
	HomePage hp = new HomePage(driver);
	hp.clickOnOrgLink();
	
	WebDriverUtility wb = new WebDriverUtility();
	
	WebElement lastRow = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]/a[@title='Organizations']"));
	wb.scrollAction(driver, lastRow);
	Thread.sleep(10000);
	System.out.println(lastRow.getText());
	Thread.sleep(5000);
	
	}

}
