package com.vtiger_sdet31;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;
import com.vtiger.objectrepository.Contactpage;
import com.vtiger.objectrepository.Contactsinfo;
import com.vtiger.objectrepository.CreateOrganizationPage;
import com.vtiger.objectrepository.Createnewcontactpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Abhishek
 *
 */
@Listeners(com.vtiger.genericutility.ListenerImplementationClass.class)
public class CreatecontactsTest extends BaseClass {
	@Test
		public void createContact() throws Throwable {
    
        /* fetch testdata from excelsheet */
            String contactname = eLib.getDataFromExcel("Sheet1",1,9)+ jLib.getRandomNumber();
            
           
               
               /*navigate to contactslink*/
               HomePage hp = new HomePage(driver);
               hp.clickOnContactsLink();
               
               /*create new contactpage*/
               Createnewcontactpage ccp = new Createnewcontactpage(driver);
               ccp.clickoncontactimg();
               
               /* create a contactname */
               Contactpage contactpage = new Contactpage(driver);
               contactpage.createnewcontactname(contactname);
               
               /* Click on save button*/
               CreateOrganizationPage cop = new CreateOrganizationPage(driver);
       		   cop.SaveOrgButton();
               
               /*validation for contactname*/
               Contactsinfo contactinfo = new Contactsinfo(driver);
               String actualmsg = contactinfo.actualcontactname().getText();
              
               Assert.assertEquals(actualmsg.contains(contactname), true);

//               if(actualmsg.contains(contactname)) {
//               	System.out.println(contactname+"is verified==pass");
//               } else {
//              	System.out.println(contactname+ "is not verified==fail");
//               }
             
              }
               
        	}


	
