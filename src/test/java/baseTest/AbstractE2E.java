package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.CapabilityFactory;
import utilities.OptionsManager;
import utilities.TestHandler;

public abstract class AbstractE2E {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static String url;
	private static int implicitWaitInSeconds;
	private static int pageLoadTimeoutInSeconds;

	public static TestHandler testHandler;

	static OptionsManager optionsManager;

	public static CapabilityFactory capabilityFactory = new CapabilityFactory();

	@BeforeSuite
	public void startDocker() throws IOException {
		//docker run -d -p 7080:5000 gprestes/the-internet
	}

	@AfterSuite
	public void stopDocker(){
		//docker stop
	}

	public static WebDriver getInstance() throws IOException {
		String configFile = "./config/test.properties";
		FileInputStream stream = new FileInputStream(configFile);
		prop = new Properties();
		prop.load(stream);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		implicitWaitInSeconds = Integer.parseInt(prop.getProperty("implicitWaitInSeconds"));;
		pageLoadTimeoutInSeconds = Integer.parseInt(prop.getProperty("pageLoadTimeoutInSeconds"));;
		optionsManager = new OptionsManager();
		testHandler = new TestHandler();

		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		ChromeOptions chromeOptions = optionsManager.getChromeOptions();

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitInSeconds));
		driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(pageLoadTimeoutInSeconds));
		return driver;
	}
}
