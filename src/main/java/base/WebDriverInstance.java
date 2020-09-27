package base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverInstance {
	private static WebDriver driver;

	public static WebDriver getInstanceOfWebDriver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		
		String downloadFilepath =System.getProperty("user.dir")+ "\\downloadfiles";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap);
    	driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		return driver;

	}

	public static void Quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

}
