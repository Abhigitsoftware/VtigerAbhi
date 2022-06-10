package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBoxselect {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		
		String browser = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		
				
		//run time polymorphism
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is "+ browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is "+ browser);
		}else {
			driver = new ChromeDriver();
		}
		
		wLib.maximizeWindow(driver);
		driver.get(url);
		wLib.waitForPageToLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
//		List<WebElement> allcheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		int lastbox = allcheckbox.size()-1;
//		System.out.println("The size of checkbox is"+lastbox);
//		allcheckbox.get(lastbox).click();
		
	}

}
