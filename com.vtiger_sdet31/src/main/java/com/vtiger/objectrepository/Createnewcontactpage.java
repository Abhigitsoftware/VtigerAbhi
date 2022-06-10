package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewcontactpage {

	//Initialization of web elements

	public Createnewcontactpage(WebDriver driver) 
	{
      PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactimg;
	public WebElement getCreatecontactimg() {
		return createcontactimg;
	}
	public void clickoncontactimg()
	{
		createcontactimg.click();
	}
}
