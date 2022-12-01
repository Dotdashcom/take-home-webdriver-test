package qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			//System.out.println(System.getProperty("user.dir") + " ---- current dir");
			FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\config.properties");

			prop.load(f);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void initialization() {
		
		String browser = prop.getProperty("browsername");
//		System.out.println(browser);
				
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//driver.get(prop.getProperty("baseurl"));
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}
