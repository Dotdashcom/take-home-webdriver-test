package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.JSPage;

public class JSErrorTest extends BaseClass {
	JSPage jSPageObj;

	public JSErrorTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/javascript_error");
		jSPageObj = new JSPage();
	}

	@Test
	public void JSAlert() throws InterruptedException {
		LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
		System.out.println("Print all log " + jsErrors.getAll());
		System.out.println("print index 0 log " + jsErrors.getAll().get(0));
		Assert.assertTrue(jsErrors.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
