package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	//fetching configuration file properties
	
	public BaseClass() {	
	
		
		try {
			
		FileInputStream file = new FileInputStream("C:\\Users\\Service 1\\eclipse-workspace\\Webdriver\\src\\test\\java\\configuration\\Config.properties");
		
		prop.load(file);
		
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//setting bowser drivers and loading url
	public static void initiate() {
		
		String Browser = prop.getProperty("Browser");
		
		if (Browser.equals("Chrome")) {
			System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(Browser.equals("FireFox")){
			System.setProperty("webDriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (Browser.equals("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Service 1\\eclipse-workspace\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		
	}
}
