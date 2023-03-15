package com.dotdash.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
public static WebDriver driver;
public Properties prop;

public TestBase() {
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/com/dotdash/config/config.properties");
		prop.load(fis);
		
	}catch(IOException e){

		
	}
}	
public void setupdownload(String urlPath) {
	String location = System.getProperty("user.dir")+"\\Downloads";
	HashMap preferences= new HashMap();
	preferences.put("download.default_directory",location);
	
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", preferences);
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	String burl=prop.getProperty("baseUrl");
	driver.get(burl+urlPath);
}
@And("user closes the browser")
public void teardown() {
	driver.quit();

}
}