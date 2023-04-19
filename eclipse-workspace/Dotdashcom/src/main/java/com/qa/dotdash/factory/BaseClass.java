package com.qa.dotdash.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.dotdash.browsers.Browsers;
import com.qa.dotdash.utils.Proxywrapper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver webdriver;
	public Properties prop;
	public static String username;
	public String password;

	public BaseClass() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./src/main/java/configurationProperties");
			try {
				prop.load(file);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	private static final Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

	public void intialization() {
		// Manages the driver for the browser on which testing is performed
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		switch (DEFAULT_BROWSER.getBrowsername()) {

		case "Chrome":

			webdriver = new Proxywrapper(WebDriverManager.chromedriver().create());
			break;

		case "Firefox":
			webdriver = new Proxywrapper(WebDriverManager.firefoxdriver().create());
			break;

		case "MicrosoftEdge":
			webdriver = new Proxywrapper(WebDriverManager.edgedriver().create());
			break;

		default:
			System.out.println(("Verify you have passed the correct browser name"));
			break;
		}
		webdriver.manage().window().maximize();
		String url = prop.getProperty("base_url");
		System.out.println(url);
		webdriver.get(url);
		webdriver.manage().deleteAllCookies();
	}

	public void quitBrowser() {
		webdriver.quit();
	}
}
