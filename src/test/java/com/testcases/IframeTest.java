package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class IframeTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("iframeURL"));
	}

	@Test(priority = 2)
	public void iFramesTest() throws Exception {
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		WebElement textField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
		textField.clear();
		textField.sendKeys("Hi");
		String paragraphText = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(paragraphText, "Hi", "Dose not match");//Assert
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Format']")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
