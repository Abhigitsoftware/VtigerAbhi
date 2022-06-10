package com.vtiget.opportunityrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOppImg;

	public WebElement getCreateOppImg() {
		return createOppImg;
	}
	//business logic
	/**
	 * This method will click on Create opportunity image
	 */
	public void clickOnCreateOpp() {
		createOppImg.click();
	}
}
