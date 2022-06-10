package com.vtiger.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;
import com.vtiget.opportunityrepository.CreateOpportunityPage;
import com.vtiget.opportunityrepository.HomePage;
import com.vtiget.opportunityrepository.LoginPage;
import com.vtiget.opportunityrepository.OpportunityPage;
import com.vtiget.opportunityrepository.VerifyOpportunityPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Abhishek
 *
 */
public class VerifyOpportunityPomTest extends BaseClass {
	@Test
	public void verifyOpp() throws Throwable {
		
		/*Read Test data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + jLib.getRandomNumber();
		String oppName=eLib.getDataFromExcel("Sheet1", 1, 6) + jLib.getRandomNumber();
		String lastName=eLib.getDataFromExcel("Sheet1", 3, 3);
		String calenderDate=eLib.getDataFromExcel("Sheet1", 1, 7);
		
		
		
		/* Navigate to Contacts */
		HomePage hp = new HomePage(driver);
		hp.getContactsLink();
		/* Navigate to opportunity */
		hp.clickOnOpportunitiesLink();
			
		/* Navigate to Create opportunity */
		OpportunityPage opp = new OpportunityPage(driver);
		opp.clickOnCreateOpp();
		
		/* Create opportunity */
		CreateOpportunityPage createOppPage = new CreateOpportunityPage(driver);
		createOppPage.OpportunityName(oppName);
		createOppPage.selectcontact();
		createOppPage.relatedtoIcon();
		createOppPage.createOpportunity(driver, lastName);
		createOppPage.calenderSelect(calenderDate);
		createOppPage.SaveOrgButton();
		
		/* Verify Opp name*/
		VerifyOpportunityPage oppInfo = new VerifyOpportunityPage(driver);
		wLib.waitForElementToBeClickAble(driver, oppInfo.getHeaderText());
		String headerInfo=oppInfo.headerTextVerify();
		if(headerInfo.contains(oppName)) {
			System.out.println("lastName name created successfully = PASS");
		}else {
			System.out.println("lastName failed to create  = FAIL");
		}
		
	}

}
