package pages.Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import pages.Driver;
import pages.JavaScriptAlerts;

public class TC15_JsAlertText extends Driver{

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	
	@Test
	public void ValidateJsAlertText() {
		JavaScriptAlerts.NavigateToJSAlertPage();
		String message = JavaScriptAlerts.GetAlertText();
		Assert.assertTrue(message.contains("I am a JS Alert"));
		
	}
	
	@Test
	public void ValidateJsConfirmAndText() {
		JavaScriptAlerts.NavigateToJSAlertPage();
		String message = JavaScriptAlerts.AcceptAlertAndGetText();
		Assert.assertTrue(message.contains("I am a JS Confirm"));
		
	}
	
	
	@Test
	public void ValidateJsPromtAndText() {
		JavaScriptAlerts.NavigateToJSAlertPage();
		String message = JavaScriptAlerts.OpenAlertAndEnterText();
		Assert.assertTrue(message.contains("JS prompt"));
		
	}
	@AfterClass
	public static void tearDown() throws Exception {
		Driver.cleanup();
	}
	

}
