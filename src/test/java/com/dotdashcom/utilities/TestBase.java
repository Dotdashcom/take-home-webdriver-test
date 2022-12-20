package com.dotdashcom.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>() ;

	@BeforeClass
	public WebDriver setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		tdriver.set(driver);
		 
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
		
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tdriver.get();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
