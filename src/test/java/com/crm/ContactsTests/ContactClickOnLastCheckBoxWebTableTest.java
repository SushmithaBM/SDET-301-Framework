package com.crm.ContactsTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class ContactClickOnLastCheckBoxWebTableTest extends BaseClass{
	
	
	@Test
	public void contactsCheckBox() throws Throwable {
	
	/* Navigate to Contact Link*/
	HomePage hp = new HomePage(driver);
	hp.clickOnContactLink();
	
	WebDriverUtility wb = new WebDriverUtility();
	
	WebElement lastCheckBox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[1]/input[@name='selected_id']"));
	wb.scrollAction(driver, lastCheckBox);
	Thread.sleep(10000);
	lastCheckBox.click();
	Thread.sleep(5000);
	
	List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
    int rows = rowsNumber.size();
	for(int i=rows-1;i<rowsNumber.size();i++) {
    	
    	rowsNumber.get(i).click();
    	
    }
	
	
	/*List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	WebElement ele1 = rowsNumber.get(rowsNumber.size()-1);
	wb.scrollAction(driver, ele1);
	ele1.click();
	Thread.sleep(5000);*/
	
	}

}
