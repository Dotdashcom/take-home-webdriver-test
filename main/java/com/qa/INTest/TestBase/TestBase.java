package com.qa.INTest.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.INTest.Utils.Utils;

public class TestBase {

	public static FileInputStream fis;
	public static Properties prop;

	public static WebDriver driver;
	
	

	public TestBase() {

		try {
			fis = new FileInputStream(
					"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\src\\main\\java\\com\\qa\\INTest\\Config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initilize() {

		String browserName = prop.getProperty("Browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumCopy\\SeleniumJars_Copy\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
		

	}
}
