package TheInternet.TheInternet;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	
	public static void driverInitialization(){
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	public void openWebPage(String url) {
		
		driver.get(url);
    	driver.manage().window().maximize();
    	try {
    		Thread.sleep(4000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	
	}




}