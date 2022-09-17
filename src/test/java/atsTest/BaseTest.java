package atsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import junit.framework.TestCase;

public class BaseTest extends TestCase{
WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		//loginPage.browserInitialization();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
      driver.quit();		    
	}
		
		
}
