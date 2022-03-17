package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Step 1: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutlnk;
	
	//Step 2: Initialization - use constructor
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	//Step 3: generate getters
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}

	//Business Library
	public void clickOnOrgLink() {
		
		organizationLnk.click();
	}
	
	public void clickOnContactLink() {
		
		contactsLnk.click();
	}
	
	public void clickOnProductsLink() {
		
		productsLnk.click();
	}
	
	public void clickOnMoreLink() {
		
		moreLnk.click();
	}
	
	public void clickOnCampaignLink() {
		
		campaignsLnk.click();
	}
	
	public void clickOnOpportunitiesLink() {
		
		opportunitiesLnk.click();
	}

	public void signOutOfApp(WebDriver driver) {
		
		mouseHover(driver, adminstratorImg);
		signOutlnk.click();
	}
}
