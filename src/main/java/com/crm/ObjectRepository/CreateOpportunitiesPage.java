package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunitiesPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy(id = "related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::img[@alt='Select']")
	private WebElement conLookUpImg;
	
	@FindBy(xpath = "//input[@name='campaignid']/following-sibling::img[@alt='Select']")
	private WebElement campLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	
	
	//Initialization
	public CreateOpportunitiesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	
	//Utilization
	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return relatedToDropDown;
	}


	public WebElement getConLookUpImg() {
		return conLookUpImg;
	}


	public WebElement getCampLookUpImg() {
		return campLookUpImg;
	}


	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	//Business Library
	
	public void createOpportunity(String opportunityName) {
		
		opportunityNameEdt.sendKeys(opportunityName);
		saveBtn.click();
	}
	
	public void createOpportunity(WebDriver driver,String opportunityName, String contactName, String campaignName, String leadSource) throws Throwable {
		
		opportunityNameEdt.sendKeys(opportunityName);
		select("Contacts",relatedToDropDown);
		conLookUpImg.click();
		switchTowindow(driver,"Contacts");
		searchEdt.sendKeys(contactName);
		searchBtn.click();
		String cn= " "+contactName;
		driver.findElement(By.xpath("//a[text()='"+cn+"']")).click();
		switchTowindow(driver,"Potentials");
		campLookUpImg.click();
		switchTowindow(driver,"Campaigns");
		searchEdt.sendKeys(campaignName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		switchTowindow(driver,"Potentials");
		select(leadSource,leadSourceDropDown);
		saveBtn.click();
	}
	
	

}
