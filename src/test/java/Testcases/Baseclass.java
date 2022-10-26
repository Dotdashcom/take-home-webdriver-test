package Testcases;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	public String baseURL = "http://localhost:7080/login";
	public String username = "tomsmith";
	public String password = "SuperSecretPassword!";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GURPREET\\eclipse-workspace\\Projectv1_gurpreet\\Drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
