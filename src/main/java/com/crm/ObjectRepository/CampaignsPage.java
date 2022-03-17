package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignsPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaignLookUpImg;

	//Initialization
	public CampaignsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	
	//Utilization
	public WebElement getCampaignLookUpImg() {
		return campaignLookUpImg;
	}
	
	//Business Library
	
	public void clickOnCampaignsLookUpImg() {
		
		campaignLookUpImg.click();
		
	}
}
