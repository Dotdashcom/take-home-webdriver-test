package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.internet.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	String baseurl = readConfig.getBaseUrl();
	String loginurl = readConfig.getLoginUrl();
	String checkboxUrl = readConfig.getcheckboxurl();
	String browser = readConfig.getBrowser();
 
	public static WebDriver driver;
//	public static Logger logger;

	@BeforeClass
	public void setup()
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(baseurl);
	

	}
	
	@AfterClass
	public void tearDown()
	{
	//	driver.close();
	//	driver.quit();
	}





}
