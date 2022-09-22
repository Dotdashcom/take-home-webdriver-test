package resources;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver driver;
	protected String dPath;
	public WebDriver openBrowser()
	{
		dPath =System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", dPath);
		ChromeOptions options=new ChromeOptions();
		 options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("headless");
		 driver= WebDriverManager.chromedriver().capabilities(options).create();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public void closeDriver(WebDriver driver) {
		driver.quit();
	}
	
}
