
  package com.vtiger_sdet31;
  
 
  import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.CreateCampaignpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.OrganiZationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
  @Listeners(com.vtiger.genericutility.ListenerImplementationClass.class)
  public class CampaignTest extends BaseClass {
  
  @Test 
  public void campaign() throws Throwable {
  
  String campaignName = eLib.getDataFromExcel("Sheet1", 1, 5) +jLib.getRandomNumber();
 
  //click on organization link 
  HomePage homepage=new HomePage(driver);
  homepage.movetomore(driver);
  
  //click on "+" image in Campaigns Page 
  CreateCampaignpage campaign = new CreateCampaignpage(driver); 
  campaign.clickOnCampaignLink();
  campaign.clickOnCampaignImg();
  campaign.enterCampaignName(campaignName);
  campaign.clickOnSaveButton(driver);
  String headerText =campaign.ActualCampaignName();
 
  Assert.assertEquals(headerText.contains(campaignName),true);
//  if(headerText.contains(campaignName)) {
//	  System.out.println("PASS: Campaign name is created");
//  }else {
//	  System.out.println("FAIL: Campaign not created");
//  } 
  
  }
  
  }
 