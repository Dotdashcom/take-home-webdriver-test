package com.dotdash.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.dotdash.Browser.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ProxyDriver;

public class BaseClass {

	public static WebDriver webdriver;
	public Properties prop;
	public static String username;
	public String password;

	private static final Browser DEFAULT_BROWSER = Browser.GOOGLE_CHROME;

	public BaseClass() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./src\\main\\java\\com\\internet\\config\\Config.properties");
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
			System.out.println(("Verify that you have passed the correct browser name"));
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
