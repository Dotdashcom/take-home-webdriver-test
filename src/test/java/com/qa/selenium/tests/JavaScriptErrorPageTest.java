package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.JavaScriptErrorPage;

public class JavaScriptErrorPageTest extends TestBase {

	JavaScriptErrorPage javaScriptErrorPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "javascript_error");
		javaScriptErrorPage = new JavaScriptErrorPage();
	}
	
	@Test
	public void  jserror() {
		
	Assert.assertEquals(javaScriptErrorPage.logError(), prop.getProperty("JSError"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
