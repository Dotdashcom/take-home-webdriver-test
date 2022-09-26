package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static Properties config = new Properties();
	public static WebDriver driver = null;
	
	@BeforeSuite()
	public static void init() throws IOException {
		if (driver == null) {
			// load config property file
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
									
			if ((System.getProperty("os.name").contains("Window"))&&(config.getProperty("browser").equals("chrome"))) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if((System.getProperty("os.name").contains("Linux"))&&(config.getProperty("browser").equals("chrome"))){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\driver\\chromedriver");
				driver = new ChromeDriver();
			}
			
			driver.get(config.getProperty("baseURL"));
			driver.manage().window().maximize();

			// Global implicit Wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	@AfterSuite()
	public static void tearDown() throws IOException {
		
		if(driver!=null) {
		  driver.quit();
		 	}
	}
}
