package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderTodayDate {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		LocalDateTime dateTime = LocalDateTime.now();
		int day = dateTime.getDayOfMonth();
		int year = dateTime.getYear();
		String month = dateTime.getMonth().name();
		String actualmonth = month.substring(0, 1).toUpperCase()+month.substring(1).toLowerCase();
		String monthandYear = actualmonth+" "+year;
		String finalFormat = +day+"-"+monthandYear;
		System.out.println(finalFormat);
		
		Actions action =new Actions(driver);
		action.moveByOffset(20, 30).click().perform();
		
		driver.findElement(By.cssSelector("span[class='langCardClose']")).click();
				
		driver.findElement(By.cssSelector("label[for='departure']")).click();
		
		String calendarelement="//div[text()='"+monthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		
		for(int i=0;i<24;i++) {
			 
			 try {
				 driver.findElement(By.xpath(calendarelement)).click();
				 break;
			 }catch(Exception e) {
				 driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
			 }
			 
		}
	}

}
