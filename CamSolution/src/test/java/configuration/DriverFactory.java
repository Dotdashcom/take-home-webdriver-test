package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver getDriver(Browser browser) {
		switch(browser) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
				return new ChromeDriver();				
			case FIREFOX:
				throw new UnsupportedOperationException("Support for Firefox not implemented yet");
			case EDGE:
				throw new UnsupportedOperationException("Support for Edge not implemented yet");
			// etc.
		}		
			
		return null;
	} 	
}
