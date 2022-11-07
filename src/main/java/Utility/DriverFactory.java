package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	public WebDriver driver;
	
	public WebDriver getDriver(String drivertype) 
	{
		
		drivertype="chrome";
		switch(drivertype)
		{
		case "chrome":
			driver=createChromeDriver();
			break;
			
		case "firefox":
			driver=createFFDriver();
			break;
			
		case "safari":
				driver=createSafariDriver();
				break;
				
		case "IE":
					driver=createIEDriver();
					break;
			
		default:
			      throw new RuntimeException("please check the browser");
		}
		
		return driver;
		
	}

	private static WebDriver createIEDriver() {
		System.setProperty("","");
		WebDriver driver=new InternetExplorerDriver();
		return driver;
	}

	private static WebDriver createSafariDriver() {
		System.setProperty("","");
		WebDriver driver=new SafariDriver();
		return driver;
	}

	private static WebDriver createFFDriver() {
		System.setProperty("","");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}

	private static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}

}
