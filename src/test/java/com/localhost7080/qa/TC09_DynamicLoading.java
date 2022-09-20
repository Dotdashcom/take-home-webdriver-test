package com.localhost7080.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC09_DynamicLoading {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dynamic_loading/2");

		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Click on button and wait until text "Hello World!" appear
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		Assert.assertEquals(driver.findElement(By.id("finish")).getText(), "Hello World!");

		driver.close();
		
	}

}
