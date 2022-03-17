package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductsPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productLookUpImg;
	
	//Initialization
	public ProductsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	
	//Utilization
	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}
	
	//Business Library
	
	public void clickOnCreateProductImg() {
		
		productLookUpImg.click();
		
	}

	
	
	
	

}
