package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
static WebDriver driver;
	
	public static WebDriver startBrowser( String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			String projectPath = System.getProperty("user.dir");
			String projectPathToTheDriver = "\\src\\resources\\drivers\\";
			System.setProperty("webdriver.chrome.driver",projectPath + projectPathToTheDriver + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			String projectPath = System.getProperty("user.dir");
			String projectPathToTheDriver = "\\src\\resources\\drivers\\";
			System.setProperty("webdriver.chrome.driver",projectPath + projectPathToTheDriver + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
		return driver;
		
	}
}
