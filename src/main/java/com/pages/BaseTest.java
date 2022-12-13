package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public WebDriver driver;
	public void openURL(String url) {
		driver=new ChromeDriver();
		
		driver.get(getBaseURL()+url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
	}
	
public String getBaseURL() {
	
	return "https://localhost:7080";
		
	}

}
