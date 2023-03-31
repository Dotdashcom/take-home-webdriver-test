package dotDashcom.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//dotDashcom//resources//GlobalData.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--headless");
			
			String downloadLocation=System.getProperty("user.dir")+"//Downloads//";
			HashMap<String, Object> chromePreference = new HashMap<>();
			chromePreference.put("download.default_directory", downloadLocation);
			options.setExperimentalOption("prefs", chromePreference);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public WebDriver setup(String resource) throws IOException {

		driver = initializeDriver();
		String baseUrl = prop.getProperty("baseUrl");
		driver.get(baseUrl + resource);
		return driver;
	}

	@After
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
