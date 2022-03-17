package com.crm.ContactsTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class DeleteFifthElementContactTest extends BaseClass{
	
	@Test
	public void deleteFifthElementWebTable() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		WebDriverUtility wb = new WebDriverUtility();
		
		WebElement delLnk = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[10]/a[text()='del']"));
		delLnk.click();
		wb.acceptAlert(driver);
		//System.out.println("No of rows in this table : " + rowCount);
		
		//for(WebElement ele : fifthRow) {

		//	ele.click();}
				
		
	}
	

}
