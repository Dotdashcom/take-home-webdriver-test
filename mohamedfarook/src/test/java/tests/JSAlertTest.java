package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.JSPage;

public class JSAlertTest extends BaseClass {
	JSPage jSPageObj;

	public JSAlertTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/javascript_alerts");
		jSPageObj = new JSPage();
	}

	@Test
	public void JSAlert() throws InterruptedException {
		jSPageObj.jsAlert.click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals(alert1.getText(), "I am a JS Alert");
		alert1.accept();
		jSPageObj.jsConfirm.click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals(alert2.getText(), "I am a JS Confirm");
		alert2.accept();
		jSPageObj.jsPrompt.click();
		Thread.sleep(2000);
		Alert alert3 = driver.switchTo().alert();
		Assert.assertEquals(alert3.getText(), "I am a JS prompt");
		alert3.sendKeys("You must choose me");
		Thread.sleep(2000);
		alert3.accept();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
