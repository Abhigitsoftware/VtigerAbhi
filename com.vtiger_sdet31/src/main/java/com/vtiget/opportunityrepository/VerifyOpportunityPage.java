package com.vtiget.opportunityrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutility.WebDriverUtility;

public class VerifyOpportunityPage extends WebDriverUtility {
	public VerifyOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderText;


	public WebElement getHeaderText() {
		return HeaderText;
	}
	//business logic
	
	
	public String headerTextVerify() {
		return HeaderText.getText();
	}
}
