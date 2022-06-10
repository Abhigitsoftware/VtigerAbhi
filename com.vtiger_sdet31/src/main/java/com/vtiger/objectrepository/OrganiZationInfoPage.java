package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganiZationInfoPage {
	public OrganiZationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ActualOrgName;

	public WebElement getActOrgName() {
		return ActualOrgName;
	}
	//business logic
	public String ActOrgName() {
		return ActualOrgName.getText();
	}

}
