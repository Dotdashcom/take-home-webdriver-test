package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;



public class BaseTest {
	WebDriver driver;
	public LandingPage landingpage;	

	public WebDriver openbrowser() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\assighment\\take-home-webdriver-test\\SeleniumTest\\src\\main\\java\\Resources\\GlobalData.properties");
		Properties property = new Properties();
		property.load(fis);

		String browserName = property.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
		return driver;

	}

	@BeforeMethod
	public  LandingPage launchApplication() throws IOException, InterruptedException
	{ 
		driver = openbrowser();
		landingpage = new LandingPage(driver);
		landingpage.getTo();
		return landingpage;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
