package com.vtiget.opportunityrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//Intitialization of WebElements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Declaration of Web Elements
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getSignOutIconImage() {
		return AdministratorImg;
	}
	
	//business logic
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink() {
		organizationLink.click();
	}
	
	/**
	 * This method will click on opportunities link
	 */
	public void clickOnOpportunitiesLink() {
		opportunitiesLink.click();
	}
	
	/**
	 * This method will logout the application
	 * @param driver
	 */
	public void logout(WebDriver driver) {
	mouseOverOnElement(driver,AdministratorImg);
	signOutLink.click();	
}
}
