package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage  extends WebDriverUtility{
	
			// Declaration
			@FindBy(name = "campaignname")
			private WebElement campaignNameEdt;
			
			@FindBy(xpath = "//input[@name='product_name']/following-sibling::img[@alt='Select']")
			private WebElement productNameLookUpImg;
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			
			@FindBy(name = "search_text")
			private WebElement searchEdt;
			
			@FindBy(name = "search")
			private WebElement searchBtn;
			
			// Initialization
			public CreateCampaignPage(WebDriver driver) {
				
				PageFactory.initElements(driver, this);
			}

			
			// Utilization
			public WebElement getCampaignNameEdt() {
				return campaignNameEdt;
			}

			public WebElement getProductNameLookUpImg() {
				return productNameLookUpImg;
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
			public void createNewCampaign(WebDriver driver, String campaignName) {
				campaignNameEdt.sendKeys(campaignName);
				saveBtn.click();	
			}
			
			public void createNewCampaign(WebDriver driver,String campaignName, String productName) {
				
				campaignNameEdt.sendKeys(campaignName);
				productNameLookUpImg.click();
				switchTowindow(driver, "Products");
				searchEdt.sendKeys(productName);
				searchBtn.click();
				driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
				switchTowindow(driver, "Campaigns");
				saveBtn.click();
			}
			
			

}
