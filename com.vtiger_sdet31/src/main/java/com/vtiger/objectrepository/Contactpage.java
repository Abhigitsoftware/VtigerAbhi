package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	//Initialization of web elements

	public Contactpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration of web elements
	@FindBy(name="lastname")
	private WebElement newcontactname;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement clickthecontactimg;
	
	
	//getters method used in testscripit
	public WebElement getNewcontactname() {
		return newcontactname;
	}
	
	public WebElement getClickthecontactimg() {
		return clickthecontactimg;
	}
	
	//business logic
	/**
	 * this method is used to create contactname
	 * @param contactname
	 */
	public void createnewcontactname(String contactname)
	{
		newcontactname.sendKeys(contactname);
	}
	/**
	 * this method is used to click the contactimg
	 */
	public void clickoncontactimg()
	{
		clickthecontactimg.click();
	}
	

}
