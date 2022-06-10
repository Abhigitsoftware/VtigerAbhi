package com.crm.products;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.Productinformationpage;
import com.vtiger.objectrepository.Productpage;
import com.vtiger.objectrepository.Productspage;


public class ProductsTest extends BaseClass {
	@Test
	public void Products() throws Throwable {
		
		
		String productName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();

		
		// click on products link
		HomePage homepage = new HomePage(driver);
		homepage.clickonproduct();
		
		/* click on + image */
		Productspage propage = new Productspage(driver);
		propage.clickonicon();

		/* create product page*/
		Productinformationpage createpro = new Productinformationpage(driver);
		createpro.entertheproductname(productName);
		createpro.getSavebutton();
		
		/* WebDriver wait statement */
		Productpage headertext = new Productpage(driver);
		wLib.waitForElementToBeClickAble(driver,headertext.getActualproductname());
		
		/* getting text for verification of header */
		Productpage verify = new Productpage(driver);
		String headerText = headertext.actualnameofproduct();
		
		Assert.assertEquals(headerText.contains(productName),true);
//		if (headerText.contains(productName)) {
//			System.out.println(productName + " is correct=PASS");
//		} else {
//			System.out.println(productName + " is not correct=FAIL");
//		}
	
	}
}
