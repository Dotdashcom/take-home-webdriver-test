package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/resources/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	public WebDriver initializeDriver(ChromeOptions options) {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/resources/chromedriver");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();

		return driver;
		
		
	}
	
	public void closeBrowser() {
		driver.close();
		
	}
	
	public void quitBrowser() {
		driver.quit();
		
	}
	

}
