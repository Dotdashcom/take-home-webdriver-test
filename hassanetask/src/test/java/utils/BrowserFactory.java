package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

	 static WebDriver driver;
	
	public static WebDriver  startBrowser() {
		// Set Chrome Driver Properties (version(85.0.4183.83)
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// Create ChromeDriver object and launch chrome browser
		WebDriver driver = new ChromeDriver();
		// return the driver to the test class
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		return driver;
	}
}
