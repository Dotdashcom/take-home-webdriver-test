package com.dotdashcom.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_ContextMenu {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/context_menu");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void contextMenu() {
		
		Actions action = new Actions(driver);
		
		action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		Alert alertBox = driver.switchTo().alert();
		Assert.assertEquals(alertBox.getText(), "You selected a context menu");
		alertBox.accept();
	}
	
}
