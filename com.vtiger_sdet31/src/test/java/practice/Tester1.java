package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//was to work on VTIGER app
public class Tester1 {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		String orgName = "tyManthra_"+ranNum;
		
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actText = driver.findElement(By.className("dvHeaderText")).getText();
		if(actText.contains(orgName)) {
			System.out.println(orgName+" is correct=PASS");
			}else
			System.out.println(orgName+" is not correct=FAIL");
	
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);

		driver.quit();
		
		
	}

}
