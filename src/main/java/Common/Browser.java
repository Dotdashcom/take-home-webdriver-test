package Common;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Browser {
	public enum BrowserName {
		CHROME, FIREFOX
	}
	public static void closeBrowser(Config testConfig) {
		Logger.Log("Closing browser");
		if (testConfig.driver != null) {
			testConfig.driver.quit();
			testConfig.driver = null;
		}
	}
	public static WebDriver getWebDriver(Config testConfig, BrowserName browserName) {
		Logger.Log("Opening browser");
		switch (browserName) {
			case CHROME :
				System.setProperty("webdriver.chrome.driver", "Parameters/chromedriver");
				testConfig.driver = new ChromeDriver();
				testConfig.driver.manage().deleteAllCookies();
				testConfig.driver.manage().window().maximize();
				testConfig.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				break;
			case FIREFOX :
				break;
			default :
				System.out.println("BROWSER NOT SUPPORTED YET");
				break;
		}
		return testConfig.driver;
	}
	public static void openPageUrl(Config testConfig, String url) {
		Logger.Log("Opening url " + url);
		if (testConfig.driver == null) {
			BrowserName browserName = BrowserName.valueOf(testConfig.getProperty("Browser").toUpperCase());
			testConfig.driver = Browser.getWebDriver(testConfig, browserName);
		}
		testConfig.driver.get(url);
	}
	public static void refresh(Config testConfig) {
		Logger.Log("Refreshing browser");
		testConfig.driver.navigate().refresh();
	}
}
