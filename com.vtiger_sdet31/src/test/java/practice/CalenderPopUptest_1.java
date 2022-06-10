package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//Script to select Calender date in make my trip web application
public class CalenderPopUptest_1 {

	public static void main(String[] args) {
		String monthAndYear = "March 2022";
		String date = "18";
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 driver.get("https://www.makemytrip.com/");
		 Actions action = new Actions(driver);
		 action.moveByOffset(20, 30).click();
		 driver.findElement(By.id("departure")).click();
		 
		 String CalenderXpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+date+"']";
		 
		 for(;;) {
			 try {
				 driver.findElement(By.xpath(CalenderXpath)).click();
				 break;
			} catch (Exception e) {
				driver.findElement(By.xpath("svg[data-testid='rightArrow']")).click();
			}
			 
		 }
	}

}
