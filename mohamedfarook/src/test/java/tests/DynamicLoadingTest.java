package tests;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.DynamicLoadingPage;

public class DynamicLoadingTest extends BaseClass {
	DynamicLoadingPage dynLoadPageObj;

	public DynamicLoadingTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/dynamic_loading/2");
		dynLoadPageObj = new DynamicLoadingPage();
	}

	@Test
	public void checkLoading() {
		dynLoadPageObj.startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(dynLoadPageObj.HelloWorld));
		Assert.assertTrue(dynLoadPageObj.HelloWorld.isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
