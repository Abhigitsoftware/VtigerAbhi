package com.crm.vtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;
import com.vtiger.objectrepository.Productinformationpage;
import com.vtiger.objectrepository.Productpage;
import com.vtiger.objectrepository.Productspage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproducttest {
		public static void main(String[] args) throws Throwable {
	/* create objects*/
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
		WebDriver driver=null;
		/*read commondata*/
		String browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		String username=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		
		/*read testdata*/
		
		String product=eLib.getDataFromExcel("Sheet1",1,4)+jLib.getRandomNumber();
		/*launch the browser*/
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
	    /*login to app*/
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get("http://localhost:8888/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
	
	     /*create new product*/
		HomePage hp=new HomePage(driver);
         hp.clickonproduct();
	     
	     /*click on icon to create new product*/
         Productspage pp=new Productspage(driver);
	     pp.clickonicon();
	     
	     /*enter the new product name*/
	     Productinformationpage pip=new Productinformationpage(driver);
	     pip.entertheproductname(product);
	     
	     /*validate whether producted is created or not*/
	     Productpage pps=new Productpage(driver);
	   // wLib.waitForElementToBeClickAble(driver, pps.actualnameofproduct());
	     String actualnameofproduct=pps.actualnameofproduct();
	     if(actualnameofproduct.contains(product))
	     {
	    	 System.out.println("product is created ===pass");
	     }
	     else
	     {
	    	 System.out.println("product is not created====fail");
	     }
	     
	     /*logout*/
	     hp.logout(driver);
	     
	     /*close the browser*/
	     driver.close();
		
		
		
	}	

}
