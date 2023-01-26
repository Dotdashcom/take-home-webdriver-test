package com.qa.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.selenium.util.TestUtil;




public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static TestUtil testutil;
	
	public TestBase() {

	try {
		
			 prop = new Properties();

		FileInputStream ip= new FileInputStream("C:\\Program Files\\Selenium Workspace\\SeleniumTestPull\\src\\main\\java\\com\\qa\\selenium\\config\\config.properties");
	prop.load(ip);}
	catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}	
	
	catch (IOException e){
		e.printStackTrace();
	} 
	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "C:\\\\SeleniumJars\\\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait,TimeUnit.SECONDS );
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		
		
	}
}


