package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;

public class JSErrorTest extends GenericPage {

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/javascript_error");
	}

	@Test
	public void tcJSError() throws InterruptedException {
		Thread.sleep(2000);
		LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
		Assert.assertTrue(jsErrors.getAll().get(0).getMessage().contains("Uncaught TypeError"));
	}
}