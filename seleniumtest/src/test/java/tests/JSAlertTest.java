package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.JSAlertPage;

public class JSAlertTest extends GenericPage {
	JSAlertPage jsAlertPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage = new JSAlertPage();
	}

	@Test
	public void tcJSAlert() throws InterruptedException {
		jsAlertPage.jsAlert.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		Assert.assertEquals(jsAlertPage.message.getText(), "You successfuly clicked an alert");
		Thread.sleep(2000);
		
		jsAlertPage.jsConfirm.click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(jsAlertPage.message.getText(), "You clicked: Ok");
		Thread.sleep(2000);
		
		jsAlertPage.jsPrompt.click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys("This is JS prompt text");
		alert.accept();
		Assert.assertEquals(jsAlertPage.message.getText(), "You entered: This is JS prompt text");
		Thread.sleep(2000);
	}
}