package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
//import java.nio.file.Files;
//import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * This class consists of all generic methods related to WebDriver Actions
 * @author sushmitha
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	/**
	 *This method will wait for 20 seconds for the page to load 
	 * @param driver
	 */
	 public void waitForPageLoad(WebDriver driver){
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	 }
	 
	 /**
	  * This method will wait for 10 seconds for an element to be clickable
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(element));	 
	 }

	 
	 /**
	  * This method will wait for 20 seconds for the element to be visible
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 /**
	  * This method will select data from dropdown using index
	  * @param element
	  * @param index
	  */
	 public void select(WebElement element, int index) {
		 
		Select sel = new Select(element);
		sel.selectByIndex(index);
	 }

	 /**
	  * This method will select data from dropdown using visible text
	  * @param element
	  * @param text
	  */
	 public void select(WebElement element, String text) {
		 
		 Select sel = new Select(element);
		 sel.selectByVisibleText(text);
	 }
	 
	 /**
	  * This method will select data from dropdown using value
	  * @param value
	  * @param element
	  */
	 public void select(String value, WebElement element)
	 {
		 Select sel = new Select(element);
		 sel.selectByValue(value);
	 }
	 
	 /**
	  * This method will perform mouse Hover action
	  * @param driver
	  * @param element
	  */
	 public void mouseHover(WebDriver driver, WebElement element) {
		 
		 Actions act = new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 
	 /**
	  * This method will perform drag and drop action
	  * @param driver
	  * @param src
	  * @param target
	  */
	 public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		 
		 Actions act = new Actions(driver);
		 act.dragAndDrop(src,  target).perform();
	 }
	 
	 /**
	  * This method will double click on element
	  * @param driver
	  * @param element
	  */
	 public void doubleClickAction(WebDriver driver, WebElement element){
		 
		 Actions act = new Actions(driver);
		 act.doubleClick(element);
		 
	 }
	 
	 /**
	  * This method will double click on webpage
	  * @param driver
	  */
	 public void doubleClickAction(WebDriver driver) {
		 
		 Actions act = new Actions(driver);
		 act.doubleClick().perform();
	 }
	 
	 /**
	  * This method will right click on webpage
	  * @param driver
	  */
	 public void rightClick(WebDriver driver) {
		 
		 Actions act = new Actions(driver);
		 act.contextClick().perform();
	 }
	 
	 /**
	  * This method will right click on element
	  * @param driver
	  * @param element
	  */
	 public void righClick(WebDriver driver, WebElement element) {
		 
		 Actions act = new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 
	 /**
	  * This method will press enter key
	  * @param driver
	  */
	 public void enterKeyPress(WebDriver driver)
	 {
		 Actions act = new Actions(driver);
		 act.sendKeys(Keys.ENTER).perform();
	 }
	 
	 /**
	  * This method will release the key
	  * @param driver
	 * @throws Throwable 
	  */
	 public void enterRelease(WebDriver driver) throws Throwable {
		 
		 Robot rb = new Robot();
		 rb.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 /**
	  * This method will switch to frame based on index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver, int index) {
		 
		 driver.switchTo().frame(index);
	 }
	 
	 /**
	  * This method will switch the frame based on name or ID
	  * @param driver
	  * @param nameOrId
	  */
	 public void switchToFrame(WebDriver driver, String nameOrId) {
		 driver.switchTo().frame(nameOrId);
	 }
	 
	 /**
	  * This method will switch the frame based on address of the element
	  * @param driver
	  * @param address
	  */
	 public void switchToFrame(WebDriver driver, WebElement address) {
		 
		 driver.switchTo().frame(address);
	 }
	 
	 /**
	  * This method will accept alert pop up
	  * @param driver
	  */
	 public void acceptAlert(WebDriver driver){
		 
		 driver.switchTo().alert().accept();
		 
	 } 
	 
	 /**
	  * This method will cancel the alert pop up
	  * @param driver
	  */
	 public void cancelAlert(WebDriver driver) {
		 
		 driver.switchTo().alert().dismiss();
	 }
	 
	 /**
	  * This method will switch to window depending on partial window title
	  * @param driver
	  * @param partialWinTitle
	  */
	 public void switchTowindow(WebDriver driver, String partialWinTitle) {
		 
		 //Step1 : use getWindowHandles to capture all ids
		 Set<String> windows = driver.getWindowHandles();
		 
		 //Step2 : iterate through windows
		 Iterator<String> it = windows.iterator();
		 
		 //Step3 : Check whether there is next window
		 while(it.hasNext())
		 {
			 //Step4 : capture current window id
			 String winId = it.next();
			 
			 //Step5 : switch to current window and capture title
			 String currentWinTitle = driver.switchTo().window(winId).getTitle();
			 
			//Step6 : check whether the current window is expected
			 if(currentWinTitle.contains(partialWinTitle)) {
				 break;
			 }
			 
		 }
	 }
	 
	 /**
	  * This method will take screenshot and store it in folder called as ScreenShot
	  * @param driver
	  * @param screenShotName
	  * @throws Throwable
	  */
	 public String getScreenShot(WebDriver driver, String screenShotName) throws Throwable{
		 
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String path = ".\\Screenshot\\"+screenShotName+".png";
		 File dst = new File(path);
		 Files.copy(src, dst);
		 return dst.getAbsolutePath();
		 
	 }
	 
	 /**
	  * This method perform random scroll
	  * @param driver
	  */
	 public void scrollAction(WebDriver driver) {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
	 }
	 
	 /**
	  * This method will scroll until the specified element found
	  * @param driver
	  * @param element
	  */
	 public void scrollAction(WebDriver driver, WebElement element) {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 int y = element.getLocation().getY();
		 js.executeScript("window.scrollBy(0,"+y+")",element);
		 //js.executeScript("argument[0].scrollIntoView()",element);
	 }
}

