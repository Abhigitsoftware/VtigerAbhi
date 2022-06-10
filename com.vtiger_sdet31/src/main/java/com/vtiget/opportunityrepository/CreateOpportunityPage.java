package com.vtiget.opportunityrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutility.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility   {
	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration	
	@FindBy(name="potentialname")
	private WebElement  OppNameTextField;
		
	@FindBy(id="related_to_type")
	private WebElement dropdownarrow;
	
	@FindBy(id="search_txt")
	private WebElement searchfield;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(linkText="adas")
	private WebElement selection;
		
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement relatedTolookupIcon;
	
	@FindBy(id="jscal_field_closingdate")
	private WebElement calenderselect;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement  saveButton;
	
	
	public WebElement getDropdownarrow() {
		return dropdownarrow;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	

	public WebElement getSelection() {
		return selection;
	}

	public WebElement getOppNameTextField() {
		return OppNameTextField;
	}

	
	public WebElement getRelatedTolookupIcon() {
		return relatedTolookupIcon;
	}

	public WebElement getCalenderselect() {
		return calenderselect;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	//business logic 
	/**
	 * This will enter opportunity name into text field
	 * @param oppName
	 */
	public void OpportunityName(String oppName) {
		OppNameTextField.sendKeys(oppName);
	}
	/**
	 * This method will click on "Related To" look up Icon
	 */
	public void relatedtoIcon() {
		relatedTolookupIcon.click();
	}
	
	/**
	 * This will click on down arrow icon and select Contacts
	 */
	public void selectcontact() {
		selectByVisibleText(dropdownarrow,"Contacts");
		
	}
	public void createOpportunity(WebDriver driver, String lastName) {
		switchToWindow(driver, "Contacts");
		searchfield.sendKeys(lastName);
		searchButton.click();
		selection.click();
		switchToWindow(driver, "Potentials");
	}
	
	public void switchTo(WebDriver driver,String window) {
		switchToWindow(driver, window);
	}
	
	public void SaveOrgButton() {
		saveButton.click();
	}
	
	public void calenderSelect(String calenderDate) {
		calenderselect.clear();
		calenderselect.sendKeys(calenderDate);
	}
	
}
