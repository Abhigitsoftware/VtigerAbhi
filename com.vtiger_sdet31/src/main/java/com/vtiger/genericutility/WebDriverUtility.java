package com.vtiger.genericutility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * It contains WebDriver specific reusable actions
 * @author Abhishek
 *
 */
public class WebDriverUtility {
/**
 * wait for page to load before identifying and synchronised element in DOM [HTML-Document]
 * @param driver
 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
/**
 * wait for page to load before identifying and asynchronized [java script actions] element in DOM [HTML-Document]
 * @param driver
 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
/**
 * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
 * @param driver
 * @param element
 */
 	public void waitForElementToBeClickAble(WebDriver driver, WebElement element) {
 		WebDriverWait wait = new WebDriverWait(driver,20);
 		wait.until(ExpectedConditions.elementToBeClickable(element));
 	}
/**
 * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
 * @param driver
 * @param element
 * @param pollingTime in the form second
 * @throws Throwable 
 */
 	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element,int pollingTime) throws Throwable{
 		FluentWait wait = new FluentWait(driver);
 		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
 		wait.wait(20);
 		wait.until(ExpectedConditions.elementToBeClickable(element));
 	}
 	
 /**
  *  used to Switch to Any Window based on Window Title
  * @param driver
  * @param partialWindowTitle
  */
 	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
 		Set<String> set = driver.getWindowHandles();
 		Iterator<String> it = set.iterator();
 		
 		while(it.hasNext()) {
 			String wID = it.next();
 			driver.switchTo().window(wID);
 			String currentWindowTitle = driver.getTitle();
 			if(currentWindowTitle.contains(partialWindowTitle)) {
 				break;
 			}
 				
 		}
 	
 	}
 /**
  * used to switch to Alert Window and click on Ok button 
  * @param driver
  */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
 /**
  * used to Switch to Alert Window & click on Cancel button
  * @param driver
  */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
 /**
  * used to Switch to Frame Window based on index
  * @param driver
  * @param index
  */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
 /**
  * used to Switch to Frame Window based on id or name attribute
  * @param driver
  * @param id_name_attribute
  */
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
 /**
  * used to select the value from the dropDwon  based on index
  * @param driver
  * @param index
  */
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
 /**
  * used to select the value from the dropDwon  based on value / option avlaible in GUI
  * @param element
  * @param value
  */
	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
 /**
  * used to place mouse cursor on specified element
  * @param driver
  * @param elemnet
  */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
 /**
  * used to right click  on specified element
  * @param driver
  * @param elemnet
  */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
 /**
  * 
  * @param driver
  * @param javaScript
  */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public String screenshot(WebDriver driver, String screenshotName) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = jLib.getSystemDateAndTime().replace(":", "-");
		File dest = new File("./screenshot/"+timestamp+""+screenshotName+".PNG");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
 /**
  * pass enter Key operation in to Browser
  * @param driver
  */
	public void passEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
 /**
  * used to maximize the window
  * @param driver
  */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

}

