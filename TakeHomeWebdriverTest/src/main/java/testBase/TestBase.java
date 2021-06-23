package testBase;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	public static WebDriver driver;
	
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\IT and QA\\Drivers\\chromedriver.exe"); //This is my Chrome Driver path, Need to adjust the chromedriver.exe path for tester to be able to run.
		driver = new ChromeDriver(); //Object of Chrome Driver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:7080");
	}
	
	public static void teardown() {
		driver.close();
	}
	
}
	