package com.crm.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;

public class ContactsOrgtest extends BaseClass {
	@Test
	public void CreateContact() throws Throwable {
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0);
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 3);
		
		//click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter orgname
		
		int ranNum = jLib.getRandomNumber();
		String orgNames = orgName + ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(orgNames);
		driver.findElement(By.name("industry")).click();
		WebElement industry = driver.findElement(By.name("industry"));
				
		wLib.selectByVisibleText(industry, "Healthcare");
		
		WebElement save = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, save);
		save.click();
		
		
		String actText = driver.findElement(By.className("dvHeaderText")).getText();
		if(actText.contains(orgName)) {
			System.out.println(orgNames+" is correct=PASS");
			}else {
			System.out.println(orgNames+" is not correct=FAIL");
			}
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		String parent = driver.getWindowHandle();
		wLib.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgNames);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgNames+"']")).click();
		
		wLib.switchToWindow(driver, "Contacts");
		
		WebElement conSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickAble(driver, conSave);
		conSave.click();
		
		
		String hdText1 = driver.findElement(By.className("dvHeaderText")).getText();
		if(hdText1.contains(lastName)) {
			System.out.println(lastName+" is correct=PASS");
			}else
			System.out.println(lastName+" is not correct=FAIL");
			
			
		}
	}


