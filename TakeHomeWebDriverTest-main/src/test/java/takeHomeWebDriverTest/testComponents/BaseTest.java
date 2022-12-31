package takeHomeWebDriverTest.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public WebDriver driver;
	
	public String url;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/sai/Downloads/TakeHomeWebDriverTest-main//src/main/java/takeHomeWebDriverTest/resources/GlobalData.properties");
		prop.load(fis);
		
		url = prop.getProperty("url");
		System.getProperty("webdriver.chrome.driver", "/Users/sai/Downloads/SeleniumJars/Chrome107//chromedriver");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		return driver;
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		driver = initializeDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
