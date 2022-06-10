package com.crm.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Campaignstest {
	@Test
	public void  test() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		int ranNum = jLib.getRandomNumber();

		int rowcount = eLib.getRowCount("Sheet1");
		System.out.println("total number of rows " + rowcount);

		System.out.println("================================================");

		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + ranNum;
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 3) + ranNum;
		String productName = eLib.getDataFromExcel("Sheet1", 1, 4) + ranNum;
		String campaignName = eLib.getDataFromExcel("Sheet1", 1, 5) + ranNum;

//Create organization with mandatory fields
		
		System.out.println("organization name is " + orgName);
		System.out.println("last name is " + lastName);
		System.out.println("product name is " + productName);

		String browser = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");

		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

		// run time polymorphism
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is " + browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is " + browser);
		} else {
			driver = new ChromeDriver();
		}

		wLib.maximizeWindow(driver);
		driver.get(url);
		wLib.waitForPageToLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		// click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		// click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter orgname

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("industry")).click();
		WebElement industry = driver.findElement(By.name("industry"));

		wLib.selectByVisibleText(industry, "Healthcare");

		WebElement save = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, save);
		save.click();

		String actText = driver.findElement(By.className("dvHeaderText")).getText();
		if (actText.contains(orgName)) {
			System.out.println(orgName + " is correct=PASS");
		} else {
			System.out.println(orgName + " is not correct=FAIL");
		}
		

		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		String parent = driver.getWindowHandle();
		wLib.switchToWindow(driver, "Accounts");

		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		wLib.switchToWindow(driver, "Contacts");

		WebElement conSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, conSave);
		conSave.click();

		String hdText1 = driver.findElement(By.className("dvHeaderText")).getText();
		if (hdText1.contains(lastName)) {
			System.out.println(lastName + " is correct=PASS");
		} else {
			System.out.println(lastName + " is not correct=FAIL");
		}
		System.out.println("===============");
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		driver.findElement(By.name("productname")).sendKeys(productName);
		WebElement prodSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, prodSave);
		prodSave.click();

		String hdText2 = driver.findElement(By.className("lvtHeaderText")).getText();
		if (hdText2.contains(productName)) {
			System.out.println(productName + " is correct=PASS");
		} else {
			System.out.println(productName + " is not correct=FAIL");
		}
		System.out.println("===============");
		WebElement more = driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, more);

		driver.findElement(By.name("Campaigns")).click();

		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		
		System.out.println("=================");
		String campWin = driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.id("search_txt")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
		
		wLib.switchToWindow(driver, "Campaigns");
		

		WebElement campSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, campSave);
		campSave.click();

		String hdText3 = driver.findElement(By.className("dvHeaderText")).getText();
		if (hdText3.contains(campaignName)) {
			System.out.println(campaignName + " is correct=PASS");
		} else {
			System.out.println(campaignName + " is not correct=FAIL");
		}

		  WebElement logout =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  
		  wLib.mouseOverOnElement(driver, logout); logout.click();
		  
		  driver.quit();
		 
	}
}
