package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.JavaScriptAlertsPage;

public class Tc015_JavaScriptAlertsTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/javascript_alerts");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void JavaScriptAlertsTest() throws IOException, InterruptedException {
		JavaScriptAlertsPage jsap = new JavaScriptAlertsPage(driver);
		String text = jsap.JsAlert();
		Assert.assertEquals(text, "I am a JS Alert");
		logger.info("Js_Alert message matches.");
		Thread.sleep(2000);
		String textConfirm = jsap.JsConfirm();
		Assert.assertEquals(textConfirm, "I am a JS Confirm");
		logger.info("Js_Confirm message matches.");
		Thread.sleep(2000);
		String TypedText = jsap.JsPromt();
		Assert.assertEquals(TypedText, "HI! This is the text in alert");
		logger.info("Js_Prompt text entered in alert matches.");
		bu.captureSrceenshot(driver, "JavaScriptAlertsTest");
		
	}

}
