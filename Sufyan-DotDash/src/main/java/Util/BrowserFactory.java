package Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory
{
	public static WebDriver driver;
	public static void startBrowser() 
	{
	    System.setProperty("webdriver.chrome.driver","C://Assignment//take-home-webdriver-test//Sufyan-DotDash//driver//chromedriver.exe");
		driver =new ChromeDriver();

	    driver.manage().deleteAllCookies();
	    
		driver.manage().window().maximize();
	}
	public static WebDriver GetDriver()
	{
		return driver;
	}
	public static void closeBrowser() 
	{
       driver.quit();
	}

}
