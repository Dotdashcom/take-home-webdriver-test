package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;

	private String userDirectory = System.getProperty("user.dir");
	private String ppFile = ".src/test/resources/properties/projectProperty.properties";
	private String pathToPP = userDirectory + ppFile;

	public Base() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(ppFile));
			properties = new Properties();

			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static String getBrowserName() {

		String browserName = properties.getProperty("browserName");
		return browserName;
	}

	public static String getURL() {

		String url = properties.getProperty("baseUrl");
		return url;
	}

	public static long getpageLoadTime() {
		String pageLoadTime = properties.getProperty("pageLoadTime");
		return Long.parseLong(pageLoadTime);

	}

	public static long getImplicitWait() {

		String implicitWait = properties.getProperty("implicitWait");
		return Long.parseLong(implicitWait);
	}

	public static String getUserName() {
		String userName = properties.getProperty("username");
		return userName;
	}

	public static String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

	public static String getWrongUserName() {
		String userName = properties.getProperty("WrongUsername");
		return userName;
	}

	public static String getWrongPassword() {
		String password = properties.getProperty("WrongPassword");
		return password;
	}

	public static void initializeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Base.getpageLoadTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Base.getImplicitWait(), TimeUnit.SECONDS);

	}

}
