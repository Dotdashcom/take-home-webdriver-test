package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DynamicControlPage;

public class DynamicControlsTest extends BaseClass {
	DynamicControlPage dynControlObj;

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/dynamic_controls");
		dynControlObj = new DynamicControlPage();
	}

	@Test
	public void contextTest() throws InterruptedException {
		dynControlObj.removeButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(dynControlObj.addButton));
		Assert.assertTrue(dynControlObj.addButton.isDisplayed(),"Checkbox gone");
		dynControlObj.addButton.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOf(dynControlObj.removeButton));
		Assert.assertTrue(dynControlObj.checkBoxButton.isDisplayed());
		dynControlObj.enableButton.click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.visibilityOf(dynControlObj.disableButton));
		Assert.assertTrue(dynControlObj.enableText.isEnabled());
		dynControlObj.disableButton.click();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait4.until(ExpectedConditions.visibilityOf(dynControlObj.enableButton));
		Assert.assertFalse(dynControlObj.enableText.isEnabled());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
