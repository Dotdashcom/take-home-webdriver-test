package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	private String url;
	private Properties prop;

	public WebDriver getDriver() throws IOException {

		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		prop.load(data);

		WebDriverManager.chromedriver().setup();

		if (prop.getProperty("browser").equals("chrome")) {
			ChromeOptions Option = new ChromeOptions();
			Option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(Option);
		} else if (prop.getProperty("browser").equals("firefox")) {
			FirefoxOptions Option = new FirefoxOptions();
			Option.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(Option);
		} else {
			EdgeOptions Option = new EdgeOptions();
			Option.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(Option);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		return url;
	}

	@BeforeMethod
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}