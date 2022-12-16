package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.ContextPage;

public class ContextTest extends BaseClass {

	ContextPage contextPageObj;

	public ContextTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/context_menu");
		contextPageObj = new ContextPage();
	}

	@Test
	public void contextTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.contextClick(contextPageObj.Context).perform();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "You selected a context menu");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
