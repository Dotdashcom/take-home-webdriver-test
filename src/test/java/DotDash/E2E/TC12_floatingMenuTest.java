package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC12_floatingMenuObject;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC12_floatingMenuTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC12_floatingMenuObject fmo = new TC12_floatingMenuObject(driver);
		fmo.getFloatingMenuLink().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		AssertJUnit.assertTrue(fmo.getFloatingMenu().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
