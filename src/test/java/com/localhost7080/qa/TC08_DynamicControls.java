package com.localhost7080.qa;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC08_DynamicControls {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dynamic_controls");

		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		// CHECKBOX
		// Click on button and wait until text "It's gone!" appear
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");

		// Click on button again and wait until text "It's back!" appear
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's back!");

		//INPUT
		// Click on button and wait until text "It's enabled!" appear
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's enabled!");

		// Click on button and wait until text "It's disabled!" appear
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's disabled!");
		
		driver.close();
		
	}

}
