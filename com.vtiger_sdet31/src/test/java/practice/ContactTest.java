package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactTest {
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] objArray=new Object[5][2];
		
		objArray[0][0]="Abhishek";
		objArray[0][1]="1122334455";
		
		objArray[1][0]="Ravi";
		objArray[1][1]="2233445566";
		
		objArray[2][0]="Kiran";
		objArray[2][1]="3344556677";
		
		objArray[3][0]="Sagar";
		objArray[3][1]="4455667788";
		
		objArray[4][0]="Ajay";
		objArray[4][1]="5566778899";
		
		return objArray;
		
			}
	@Test(dataProvider="getdata")
	public void multipledata(String lastname, String mobnum ) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		

		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("mobile")).sendKeys(mobnum);
		
		
		
	}
}
