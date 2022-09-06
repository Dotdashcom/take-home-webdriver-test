package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	//Create webdriver instance to use for POM
	public static WebDriver Instance;
	
	//Base Url 
	public static String Baseurl ="http://localhost:7080";
	
	
	
	//Initialize the webdriver 
	public static void Initialize()
	{
		if (Instance == null)
        {
            
		
		System.setProperty("webdriver.chrome.driver", "C:\\WebdriverTest\\chromedriver_win32\\chromedriver.exe");
		Instance = new ChromeDriver();
		
        
		
		Instance.get(Baseurl);
		
		Instance.manage().window().maximize();
		
		Instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
	}
	
	//Cleanup
	public static void cleanup()
	{
		if (Instance != null)
        {
		Instance.close();
        }
	}
	
	public static void cleanup2()
	{
		if (Instance != null)
        {
		Instance.quit();
        }
	}
	
	

}
