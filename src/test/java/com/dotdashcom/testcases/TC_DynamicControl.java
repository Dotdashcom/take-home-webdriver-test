package com.dotdashcom.testcases;

import java.time.Duration;

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

public class TC_DynamicControl {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/dynamic_controls");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void removeCheckbox() {
		
		//Hide checkbox
		driver.findElement(By.xpath("//button[text()='Remove']")).click();		
		boolean isGone = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertTrue(isGone);
	}
	
	@Test(dependsOnMethods = "removeCheckbox")
	public void checkVisiblity() {
		
		//Check if checkbox is visible		
		driver.findElement(By.xpath("//button[text()='Add']")).click();		
		Boolean isVisible = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']"))).isDisplayed();
		Assert.assertTrue(isVisible);	
	}
	
	@Test
	public void removeTextbox() {
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();		
		boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(dependsOnMethods="removeTextbox")
	public void isTextboxVisible() throws InterruptedException {
		
		//Check if checkbox is visible		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='Disable']")).click();		
		Thread.sleep(7);
		String isTextboxVisible = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")))
				.getCssValue("disabled");
		
		System.out.println(isTextboxVisible);
		//Assert.assertFalse(isTextboxVisible);	
	}
}
