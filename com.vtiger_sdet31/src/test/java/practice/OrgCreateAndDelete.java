package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.genericutility.ExcelUtility;
import com.vtiger.genericutility.FileUtility;
import com.vtiger.genericutility.JavaUtility;
import com.vtiger.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrgCreateAndDelete {

	private static final By Organizations = null;

	public static void main(String[] args) throws Throwable {
		/* Create Objects */
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*Read Test data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + jLib.getRandomNumber();
		
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);

		
		/* Login to application*/
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		  // click on organization link 
			driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click(); 
		  
		  // click on "+" image
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(); 
		  
		  // enter orgname
		  
		  driver.findElement(By.name("accountname")).sendKeys(orgName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		  /* Verification */
		  String actText = driver.findElement(By.className("dvHeaderText")).getText();
		  
		  if (actText.contains(orgName)) {
		   System.out.println(orgName +" is correct=PASS");
		  } else { 
			 System.out.println(orgName +" is not correct=FAIL"); 
		  }
		  
		  /* Again go to organization page*/
		 
		 driver.findElement(By.linkText("Organizations")).click();
				 
		 /*search for created organization */
		
			 for(;;) {
				 	try{
					 	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+orgName+"']")).click();
						 	 break;
					 	 }
					 catch(Exception e)
					 	 {
					 		 Thread.sleep(2000);
						driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
						}
					 }
			 
			 
			 
			 driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
			 driver.switchTo().alert().accept();
			 WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 wait.until(ExpectedConditions.elementToBeClickable(move));
			 
					 
		  WebElement logout =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  
		  Actions action = new Actions(driver);
			action.moveToElement(logout).perform();
			logout.click();
		  
		  driver.quit();
	
	}
}
