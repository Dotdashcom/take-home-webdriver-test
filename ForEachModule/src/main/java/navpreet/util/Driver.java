package navpreet.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	WebDriver driver;
	String url;
	
	public WebDriver initialize() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\navpreet\\util\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		url=prop.getProperty("url");
		driver.get(url);
	return driver;		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
