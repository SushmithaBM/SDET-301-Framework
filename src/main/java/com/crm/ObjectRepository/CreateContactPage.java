package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	//Step 1: Declaration
		@FindBy(name = "lastname")
		private WebElement lastNameEdt;
		
		
		@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@alt='Select']")
		private WebElement orgNameLookUpImg;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		@FindBy(name = "leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(name = "search_text")
		private WebElement searchEdt;
		
		@FindBy(name = "search")
		private WebElement searchBtn;
		
		@FindBy(name = "portal")
		private WebElement portalCheckBox;
		
		@FindBy(id = "email")
		private WebElement emailEdt;
		
		@FindBy(name = "notify_owner")
		private WebElement notifyOwnerCheckBox;
		
		@FindBy(xpath = "//a[contains(text(),'Create Mail Merge templates ')]")
		private WebElement createMailMergeLnk;
		
		@FindBy(name = "binFile")
		private WebElement chooseFileBtn;
		
		@FindBy(name = "target_module")
		private WebElement moduleDropDown;
		
		@FindBy(xpath = "//input[@title='Save']")
		private WebElement mailMergeSaveBtn;
		
		//Step 2 : initialization
		public CreateContactPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//Step 3: Utilization
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getOrgSelectImg() {
			return orgNameLookUpImg;
		}
		
		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}
		
		public WebElement getOrgNameLookUpImg() {
			return orgNameLookUpImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getPortalCheckBox() {
			return portalCheckBox;
		}

		public WebElement getEmailEdt() {
			return emailEdt;
		}
		
		//Business Library
		public void createNewContact(String lastName) {
			
			lastNameEdt.sendKeys(lastName);
			saveBtn.click();
			
		}
		
		public void createContactenableNotifyOwnerCheckBox(String lastName) {
			
			
			lastNameEdt.sendKeys(lastName);
			notifyOwnerCheckBox.click();
			saveBtn.click();
		}

		public void createNewContact(WebDriver driver,String lastName, String OrgName) {
			
			lastNameEdt.sendKeys(lastName);
			orgNameLookUpImg.click();
			switchTowindow(driver, "Accounts");
			searchEdt.sendKeys(OrgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			switchTowindow(driver, "Contacts");
			saveBtn.click();
			
		}

		public void createNewContact(WebDriver driver, String lastName, String OrgName, String Lead) {
			
			lastNameEdt.sendKeys(lastName);
			orgNameLookUpImg.click();
			switchTowindow(driver, "Accounts");
			searchEdt.sendKeys(OrgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			switchTowindow(driver, "Contacts");
			select(leadSourceDropDown, Lead);
			saveBtn.click();
		}

		
		public void createNewContact(String lastName, String email) {
			
			lastNameEdt.sendKeys(lastName);
			portalCheckBox.click();
			emailEdt.sendKeys(email);
			saveBtn.click();
			
		}
		
		public void clickOnMailMerge() {
			
			createMailMergeLnk.click();
			
		}
		
		public void createMailMerge() {
			
			chooseFileBtn.sendKeys("C:\\Users\\sushmitha\\Desktop\\D\\Resume\\SUSHMITHA_BM_CV.doc");
			System.out.println("File uploaded successfully");
			Select s = new Select(moduleDropDown);
			s.selectByValue("Accounts");
			mailMergeSaveBtn.click();
		}
		
		
}
