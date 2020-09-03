package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static String baseURL="http://localhost:7080/";
	public static WebDriver driver;
	
	public static void setUp(String endpoint) {
		System.setProperty("webdriver.chrome.driver", "/home/nazarov/Downloads/chromedriver_linux64/chromedriver");
	
		driver= new ChromeDriver();
		driver.get(baseURL+endpoint);
		
	}
	

}
