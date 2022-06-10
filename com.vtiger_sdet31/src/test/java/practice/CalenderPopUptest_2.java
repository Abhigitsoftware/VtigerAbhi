package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Script to select Calender date in cleartrip web application
public class CalenderPopUptest_2 {

	public static void main(String[] args) {
		String monthAndYear = "March 2022";
		String date = "18";
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 driver.get("https://www.cleartrip.com/");
		 driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]")).click();
		 //div[contains(@class,'homeCalender')]
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
