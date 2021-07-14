package resources;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {
	public WebDriver driver;
	public DesiredCapabilities capability;
	public WebDriver initializeDriver(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator +"drivers"+File.separator+"chromedriver");
		driver = new ChromeDriver();
		//to load the whole page according to its complexity
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:7080/");
		return driver;
	}
}
