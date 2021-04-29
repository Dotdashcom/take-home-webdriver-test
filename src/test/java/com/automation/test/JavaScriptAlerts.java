package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.IframePage;
import com.automation.pageobject.JavaScriptAlertsPage;

public class JavaScriptAlerts extends BaseTest {
	@Test
	public void JavaScriptAlertsTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavaScriptAlertsPage.validateJavaScriptAlertHeader(driver);
		JavaScriptAlertsPage.javaScriptAlertMsg(driver);
		JavaScriptAlertsPage.jsConfirmButton(driver);
		JavaScriptAlertsPage.jsPromptButton(driver, "hello");
		
		
	}
}
