package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Header {
@Test
public void  header() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
	
}
}
