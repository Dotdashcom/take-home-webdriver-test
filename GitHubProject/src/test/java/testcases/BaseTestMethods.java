package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestMethods {

	WebDriver driver;
	String baseURL="http://localhost:7080";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  @BeforeTest(alwaysRun=true)
	  public void setUp() {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			

	  }
	
	  @AfterTest(alwaysRun=true)
	  public void tearDown() {
		  driver.close();
		  driver.quit();
	  }

}
