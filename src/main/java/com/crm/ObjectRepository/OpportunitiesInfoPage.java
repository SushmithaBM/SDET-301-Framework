package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OpportunitiesInfoPage extends WebDriverUtility{
	
			//Step 1: Declaration
			@FindBy(xpath = "//span[@class='dvHeaderText']")
			private WebElement headerText;
			
			//Step 2: initialization
			public OpportunitiesInfoPage(WebDriver driver) {
				
				PageFactory.initElements(driver, this);
			}

			//Step 3: Utilization
			public WebElement getHeaderText() {
				return headerText;
			}
			
			//business Library
			public String opportunityNameInfo() {
				
				String opportunityNameInfo = headerText.getText();
				return opportunityNameInfo;
				
			}

			
}
