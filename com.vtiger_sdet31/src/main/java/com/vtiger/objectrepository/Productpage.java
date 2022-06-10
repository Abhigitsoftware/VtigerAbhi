package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	/*intialization of webelement*/
	public Productpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	/*Declaration of Webelement*/
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement actualproductname;

	public WebElement getActualproductname() {
		return actualproductname;
	}
	/*business logic*/
	public String actualnameofproduct()
	{
		return actualproductname.getText();
	}
	
	
}
