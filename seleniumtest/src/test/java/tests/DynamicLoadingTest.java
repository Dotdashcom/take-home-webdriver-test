package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DynamicLoadingPage;

public class DynamicLoadingTest extends GenericPage {
	DynamicLoadingPage dynLoadPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/dynamic_loading/2");
		dynLoadPage = new DynamicLoadingPage();
	}

	@Test
	public void tcDynamicLoading() throws InterruptedException {
		Thread.sleep(2000);
		dynLoadPage.startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(dynLoadPage.message));
		Assert.assertEquals(dynLoadPage.message.getText(), "Hello World!");
	}
}