package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productinformationpage {
	/*intialization of webelement*/
public Productinformationpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*Declaration of Webelement*/
@FindBy(name="productname")
private WebElement newproduct;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebutton;

public WebElement getNewproduct() {
	return newproduct;
}

public WebElement getSavebutton() {
	return savebutton;
}
/*business logic*/
public void entertheproductname(String product)
{
	newproduct.sendKeys(product);
	savebutton.click();
}
}
