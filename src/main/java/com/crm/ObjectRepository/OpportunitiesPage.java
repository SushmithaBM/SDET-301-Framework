package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OpportunitiesPage extends WebDriverUtility{
	
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOpportunityLookUpImg;
	
	//Intialization
	public OpportunitiesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	//Utilization
	public WebElement getCreateOpportunityLookUpImg() {
		return createOpportunityLookUpImg;
	}
	
	//Business Libraries
	
	public void clickOnOpportunityLookUpImg()
	{
		createOpportunityLookUpImg.click();
	}
	
	

}
