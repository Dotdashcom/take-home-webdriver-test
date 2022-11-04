package com.Dotdashcom.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.Browser.Browser;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webdriver;
	public Properties prop;
	public static String username;
	public String password;

	private static final Browser DEFAULT_BROWSER = Browser.GOOGLE_CHROME;

	public TestBase() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./src\\main\\java\\com\\Dotdashcom\\Config\\Config.Properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void intialization() {

		username = prop.getProperty("username");
		password = prop.getProperty("password");

		switch (DEFAULT_BROWSER.getBrowsername()) {

		case "Chrome":

			webdriver = new ProxyDriver(WebDriverManager.chromedriver().create());
			break;
		case "Firefox":

			webdriver = new ProxyDriver(WebDriverManager.firefoxdriver().create());
			break;
		case "MicrosoftEdge":
			webdriver = new ProxyDriver(WebDriverManager.edgedriver().create());
			break;

		default:
			System.out.println(("Verify the browser name"));
			break;
		}
		webdriver.manage().window().maximize();
		webdriver.get(prop.getProperty("base_url"));
		webdriver.manage().deleteAllCookies();
	}

	public void quitBrowser() {
		webdriver.quit();
	}
}