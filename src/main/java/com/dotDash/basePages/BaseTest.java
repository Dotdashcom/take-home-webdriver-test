package com.dotDash.basePages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
    
		
	
	//Initialization of crome driver

	public void initialization(String browser, String url) {
		//String browserNmae = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\bodas\\Downloads\\Selenium\\Drivers\\chromedriver.exe");
			 driver= new ChromeDriver();
			 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("baseurl")+url);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
	}
	
	
	@BeforeClass
	@Parameters({"browser", "appUrl"})
	public void setUp(String testBrowser, String testUrl) {
		BufferedReader reader;
		try {
			prop = new Properties();
			reader = new BufferedReader(new FileReader("C:\\Users\\bodas\\eclipse-workspace\\dotdashmeredith\\src\\main\\java\\com\\dd\\config\\config.properties"));
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialization(testBrowser, testUrl);
			}

	/*
	
	//tear down
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
*/
}
