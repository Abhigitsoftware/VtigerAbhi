package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutility.ExcelUtility;

public class CreateOrganizationPage extends ExcelUtility {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement  OrgNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement  SaveButton;

	public WebElement getOrgNameTextField() {
		return OrgNameTextField;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void createOrg(String orgName) {
		OrgNameTextField.sendKeys(orgName);
	}
	
	public void SaveOrgButton() {
		SaveButton.click();
	}
	

}
