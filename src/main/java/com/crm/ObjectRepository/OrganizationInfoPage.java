package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	
	//Step 1: Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	//Step 2: initialization
	public OrganizationInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	//Step 3: utilization
	public WebElement getHeaderText() {
		
		return headerText;
	}
	
	//business Library
	public String OrgNameInfo() {
		
		String OrgInfo = headerText.getText();
		return OrgInfo;
		
	}
	
	public void clickOnContactLnk() {
		
		contactLnk.click();
	}

}
