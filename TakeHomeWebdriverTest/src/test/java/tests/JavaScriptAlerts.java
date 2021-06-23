package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class JavaScriptAlerts extends TestBase {
	
	@BeforeTest
	public void beforeJavaScriptAlertsTest() {
		setup();
		driver.get("http://localhost:7080/javascript_alerts");
	}

	@AfterTest
	public void afterJavaScrpitAlertsTest() {
		teardown();
	}
	
	@Test
	public void javaScriptAlertsTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		String firstAlertText = alert.getText();
		Assert.assertEquals(firstAlertText, "I am a JS Alert");
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		String secondAlertText = alert.getText();
		Assert.assertEquals(secondAlertText, "I am a JS Confirm");
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		alert.sendKeys("test123");
		alert.accept();
		String jsPromptResult = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(jsPromptResult, "You entered: test123");
	}


}
