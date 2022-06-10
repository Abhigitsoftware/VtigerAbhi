package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage {
	/*intialization of webelement*/
public Productspage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*declaration of webelement*/
@FindBy(xpath="//img[@title='Create Product...']")
private WebElement clickonnewproductimage;

public WebElement getClickonnewproducticon() {
	return clickonnewproductimage;
}
/*business logic*/
public void clickonicon()
{
	clickonnewproductimage.click();
}


}
