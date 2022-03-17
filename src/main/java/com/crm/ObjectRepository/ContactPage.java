package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactPage extends WebDriverUtility{
	
	//Step 1: declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createContactLookUpImg;
		
	//	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']")
	//	private WebElement WebTable;
		
		//Step 2: initialization
		public ContactPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
	
		}
		
		
		//Step 3: Utilization
		public WebElement getCreateContactLookUpImg() {
			return createContactLookUpImg;
		}

		//business Library
		public void clickOnCreateContactImg() {
			
			createContactLookUpImg.click();
		}

}
