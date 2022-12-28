package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends GenericPage {
	DynamicControlsPage dynamicControlsPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/dynamic_controls");
		dynamicControlsPage = new DynamicControlsPage();
	}

	@Test
	public void tcDynamicControls() throws InterruptedException {
		dynamicControlsPage.removeButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.addButton));
		Assert.assertTrue(dynamicControlsPage.addButton.isDisplayed());
		
		dynamicControlsPage.addButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.removeButton));
		Assert.assertTrue(dynamicControlsPage.checkBox.isDisplayed());
		
		dynamicControlsPage.enableButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.disableButton));
		Assert.assertTrue(dynamicControlsPage.textBox.isEnabled());
		
		dynamicControlsPage.disableButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.enableButton));
		Assert.assertFalse(dynamicControlsPage.textBox.isEnabled());
	}
}