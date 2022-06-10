package com.vtiger_sdet31;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;

import com.vtiger.objectrepository.CreateOrganizationPage;
import com.vtiger.objectrepository.HomePage;

import com.vtiger.objectrepository.OrganiZationInfoPage;
import com.vtiger.objectrepository.OrganisationPage;

/**
 * 
 * @author Abhishek
 *
 */
@Listeners(com.vtiger.genericutility.ListenerImplementationClass.class)
public class CreateOrganisationWithIndustryPomTest extends BaseClass {
	@Test
	public void createOrganization() throws Throwable {

	
		
		/*Read Test data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + jLib.getRandomNumber();
		
		
		/* Navigate to organization */
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		/* Navigate to Create organization */
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnCreateOrg();
		
		/* Create organization */
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		cop.SaveOrgButton();
		
	
		
		/* Verify Org name*/
		OrganiZationInfoPage orgInfo = new OrganiZationInfoPage(driver);
		wLib.waitForElementToBeClickAble(driver, orgInfo.getActOrgName());
		String SuccessMsg=orgInfo.ActOrgName();
		
		Assert.assertEquals(SuccessMsg.contains(orgName),true );

//		if(SuccessMsg.contains(orgName)) {
//			System.out.println("OrgName name created successfully = PASS");
//		}else {
//			System.out.println("OrgName failed to create  = FAIL");
//		}
	
		
	}

}
