package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.FloatingMenuPage;

public class FloatMenuTest extends BaseClass {
	FloatingMenuPage floatMenuPage;

	public FloatMenuTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/floating_menu");
		floatMenuPage = new FloatingMenuPage();
	}

	@Test
	public void floatMenuTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,750)");
		}
		Assert.assertTrue(floatMenuPage.floatingMenu.isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
