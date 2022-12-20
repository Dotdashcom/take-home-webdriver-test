package com.dotdashcom.testcases;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Notification {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/notification_message_rendered");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void notification() {
		
		int i=0;
		while(i<5) {
			System.out.println("iteration# "+i);
			driver.findElement(By.linkText("Click here")).click();
			
			WebElement flashBox = new WebDriverWait(driver, Duration.ofSeconds(3))
					.until(ExpectedConditions.elementToBeClickable(By.id("flash")));
			
			String msg = flashBox.getText();			
			String str[] = msg.split("\n");
			
			if(msg.contains("successful")) {
				Assert.assertEquals(str[0], "Action successful");
			}else if(msg.contains("unsuccessful")) {
				Assert.assertEquals(str[0], "Action unsuccesful, please try again");
			}
			
			i++;
		}
	}
}
