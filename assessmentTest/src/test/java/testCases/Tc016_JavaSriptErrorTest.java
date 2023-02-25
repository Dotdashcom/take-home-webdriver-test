package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.JavaScriptError;

public class Tc016_JavaSriptErrorTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/javascript_error");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void JavaSriptErrorTest() throws IOException {
		JavaScriptError jse = new JavaScriptError(driver);
		String errorText = jse.JsError();
		Assert.assertEquals(errorText, "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
		logger.info("Error message matches");
		bu.captureSrceenshot(driver, "JavaSriptErrorTest");
		
	}

}
