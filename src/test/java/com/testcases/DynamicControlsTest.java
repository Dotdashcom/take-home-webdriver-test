package com.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class DynamicControlsTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("dynamicControlURL"));
	}

	@Test(priority = 2)
	public void dynamicContentTest() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='checkbox-example']/button[text()= 'Remove']")));
		driver.findElement(By.xpath("//*[@id='checkbox-example']/button[text ()= 'Remove']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='checkbox-example']/button[text()= 'Add']")));

		List<WebElement> dynamicElement = driver.findElements(By.id("checkbox"));
		boolean checkBoxStatus = dynamicElement.size() != 0;
		Assert.assertEquals(false, checkBoxStatus);

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkbox-example']/button[text()= 'Add']")));
		driver.findElement(By.xpath("//*[@id='checkbox-example']/button[text()= 'Add']")).click();

		List<WebElement> dynamicElements = driver.findElements(By.id("checkbox"));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='checkbox-example']/button[text()= 'Remove']")));
		boolean checkBoxStatus1 = dynamicElements.size() != 0;

		Assert.assertEquals(true, checkBoxStatus1);//Assert

		// now enable and same way for Disable
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='input-example']/button[text() = 'Enable']")));
		driver.findElement(By.xpath("//*[@id='input-example']/button[text() = 'Enable']")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
