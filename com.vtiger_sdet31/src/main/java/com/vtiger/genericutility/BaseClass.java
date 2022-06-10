package com.vtiger.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver = null;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver sDriver;

	@BeforeSuite
	public void bs() {
		System.out.println("data base connection");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("execute script in parallel mode");
	}
	/* we have to use Parameters("browser") for cross browser testing only, else comment it*/
//	@Parameters("browser")
	@BeforeClass
	public void bc() throws Throwable {
		/* for cross browser tesing comment String browserName and pass (String browserName) */
		String browserName = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			throw new Exception("browser is not compatible");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO, TimeUnit.SECONDS);
		
		driver.get(url);
		sDriver=driver;
		
	}
	
	@BeforeMethod
	public void bm() throws Throwable{
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		
	}
	
	@AfterMethod
	public void am() {
		HomePage homepage = new HomePage(driver);
		homepage.logout(driver);
	}
	
	@AfterClass
	public void ac() {
		driver.quit();
	}
	
	@AfterTest
	public void at() {
		System.out.println("close parallel mode execution");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("close database connection");
	}
}
