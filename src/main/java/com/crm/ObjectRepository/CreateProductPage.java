package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	
	//Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}
	
	
	//Business Library
	public void createNewProduct(String productName) {
		
		productNameEdt.sendKeys(productName);
		saveBtn.click();
		
	}
	
	
	
	
	

}
