package com.vtiget.opportunityrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1:Create a separate java class for every page in a application 
	//Intitialization of elements
	public LoginPage(WebDriver driver) {//Rule 3:Execute all the elements & initialise the elements 
		PageFactory.initElements(driver, this);
	}
	
		
	//Declaration of web element
	@FindBy(name="user_name")//Rule 2:Identify all the elements using @findBy(Declaration)
	private WebElement userNameTextField;

	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//getters method to use it in the test script 
	//Declare all the elements as Private & provide getters method, business method
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//business logic
	public void login(String username, String password) {
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	loginButton.click();
	}
}
