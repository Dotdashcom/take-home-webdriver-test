package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class JavaScriptAlertsTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("javaScriptAlertsURL"));
	}

	@Test(priority = 2)
	public void javaScriptAlertTest() throws Exception {

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		String actualAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMessage, "I am a JS Alert", "Dose not match");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		// Alert dismiss
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		String actualAlertConfirmMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertConfirmMessage, "I am a JS Confirm", "Dose not match");
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);

		// Alert send text
		driver.findElement(By.xpath("//ul/li[3]/button")).click();
		driver.switchTo().alert().sendKeys("demo");
		String actualAlertdemoMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertdemoMessage, "I am a JS prompt", "Dose not match");//Assert
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();// terminates driver session and closes all windows
	}

}
