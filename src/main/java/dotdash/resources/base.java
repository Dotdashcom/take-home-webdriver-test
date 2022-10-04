package dotdash.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	public Properties prop;
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		
		
		 prop = new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//dotdash//resources//data.properties");
		
		prop.load(fis);
		//String browserName= System.getProperty("browser");
		String browserName= prop.getProperty("browser");
		
		
		
		if(browserName.contains("chrome")) {
			String path = System.getProperty("user.dir") + "//src//main//java//dotdash//resources//chromedriver";
			System.setProperty("webdriver.chrome.driver", path);
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("profile.default_content_settings.popups", 0);

			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

			ChromeOptions options=new ChromeOptions();

			options.setExperimentalOption("prefs", chromePrefs);
			
			driver = new ChromeDriver(options);
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			String path = System.getProperty("user.dir") + "//src//main//java//dotdash//resources//geckodriver";
			System.setProperty("webdriver.gecko.driver", path);
			
			 driver = new FirefoxDriver();
			
		}
		
		else {
			System.out.println("Browser not available");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	

}
