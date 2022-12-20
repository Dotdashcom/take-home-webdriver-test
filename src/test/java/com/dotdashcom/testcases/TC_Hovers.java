package com.dotdashcom.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Hovers {
	

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/hovers");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void hovers() {
		
		Actions action = new Actions(driver);
		List<WebElement> el = driver.findElements(By.xpath("//div[@class='figure']/img"));	
		int i=1;
		for(WebElement e : el) {
			action.moveToElement(e).perform();
			boolean str = driver.findElement(By.xpath("//div[@class='figure']["+i+"]/div[@class='figcaption']")).isDisplayed();
			Assert.assertTrue(str);
			i++;
		}
	}
}
