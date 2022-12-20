package com.dotdashcom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_NewWindow {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/windows");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void newWindow() {
		
		driver.findElement(By.linkText("Click Here")).click();
		String originalWindow = driver.getWindowHandle();
				
		for(String window : driver.getWindowHandles()) {
			
			if(!window.contentEquals(originalWindow)) {
				driver.switchTo().window(window);
				String newWindowText = driver.findElement(By.tagName("h3")).getText();
				Assert.assertEquals(newWindowText, "New Window");
			}
		}
	}
}
