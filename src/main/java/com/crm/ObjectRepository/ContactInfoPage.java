package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	
	
	//Step 1: Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		//Step 2: initialization
		public ContactInfoPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}


		//Step 3: utilization
		public WebElement getHeaderText() {
			
			return headerText;
		}
		
		//business Library
		public String lastNameInfo() {
			
			String lastNameInfo = headerText.getText();
			return lastNameInfo;
			
		}
		

}
