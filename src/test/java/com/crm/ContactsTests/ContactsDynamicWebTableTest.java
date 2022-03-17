package com.crm.ContactsTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ContactsDynamicWebTableTest extends BaseClass{
	
	
	@Test
	public void contactsCheckBox() {
	
	/* Navigate to Contact Link*/
	HomePage hp = new HomePage(driver);
	hp.clickOnContactLink();
	
	List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	int rowCount = rowsNumber.size();
	System.out.println("No of rows in this table : " + rowCount);
	for(WebElement ele : rowsNumber) {

		ele.click();
			
	}
	
	}
	
	
}
