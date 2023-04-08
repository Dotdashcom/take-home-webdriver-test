package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
		prop = new Properties();
		FileInputStream ip =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
		prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("urlLogin"));
	}	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public String getTheflashMessages() {
		return driver.findElement(By.xpath("//div[@id='flash']")).getText();
	}

}
