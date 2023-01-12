package staffitsolution.qa.wlctointernet.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	Properties prop;
//This method is used to initialize the webdriver on the basis of given browser name
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		
		System.out.println("Browser name is:" + browserName);
	    
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else {
			System.out.println("Please pass the right browser: " + browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(prop.getProperty("loginurl"));
			return driver;
	}
	
	public Properties init_prop() {
try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");;
		prop = new Properties();
		prop.load(ip);
}
catch (FileNotFoundException e) {
				e.printStackTrace();
			}
catch(IOException e)
{
	e.printStackTrace();
}
return prop;
	}
}
