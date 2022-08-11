package Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainClass
{
	public static WebDriver driver;
	public static void startBrowser() 
	{
		System.setProperty("webdriver.chrome.driver",("driver") + "/chromedriver.exe");

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
