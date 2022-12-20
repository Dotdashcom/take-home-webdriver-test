package com.dotdashcom.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Upload {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/upload");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void fileUpload() {
		String fileName = "flower.jpg";
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\deshm\\Downloads\\"+fileName);
		driver.findElement(By.id("file-submit")).click();
		
		String text = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("uploaded-files")))
				.getText();

		Assert.assertEquals(text, fileName);
	}
}
