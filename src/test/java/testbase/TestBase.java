package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static String url;

	public static WebDriver getInstance() throws IOException {

		String configFile = "./src/main/java/config/config.properties";
		FileInputStream stream = new FileInputStream(new File(configFile));

		prop = new Properties();
		prop.load(stream);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");

		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
}
