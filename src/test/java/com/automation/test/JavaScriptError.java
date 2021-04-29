package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.JavaScriptAlertsPage;
import com.automation.pageobject.JavaScriptErrorPage;

public class JavaScriptError extends BaseTest {
	
	@Test
	public void JavaScriptErrorTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/javascript_error");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavaScriptErrorPage.captureJavaScript(driver);
		
		
		
	}

}
