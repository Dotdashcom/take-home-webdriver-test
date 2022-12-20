package com.dotdashcom.testcases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_JavascriptAlerts {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/javascript_alerts");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void javascriptAlerts() {
			
		List<WebElement> li = driver.findElements(By.xpath("//ul/li/button"));
		String promtMsg = "This is a prompt msg";
		
		for(int i=0;i<li.size();i++) {
			
			WebElement el = li.get(i);
			String buttonText[] = el.getText().split("JS");
			el.click();

			Alert alert = driver.switchTo().alert();
			String str = alert.getText();
			
			if(i==2) {
				alert.sendKeys(promtMsg);
				alert.accept();
				Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(promtMsg));
			}else {
				Assert.assertEquals(str, "I am a JS"+buttonText[1]);
				alert.accept();				
			}			
		}
	}
}
