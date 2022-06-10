package com.vtiger_sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
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

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Abhishek
 *
 */
@Listeners(com.vtiger.genericutility.ListenerImplementationClass.class)
public class CreateOpportunityPomTest extends BaseClass{
	@Test
	public void createOpportunity() throws Throwable {
		
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
		createOppPage.calenderSelect(lastName);
		createOppPage.calenderSelect(calenderDate);
		createOppPage.SaveOrgButton();
						
		
	}

}
