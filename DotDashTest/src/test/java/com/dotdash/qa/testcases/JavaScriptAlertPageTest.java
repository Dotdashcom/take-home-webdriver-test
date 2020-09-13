package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.JavaScriptAlertPage;

public class JavaScriptAlertPageTest extends TestBase{
	
	JavaScriptAlertPage javaScriptAlertPage;
	
	@BeforeMethod
	public void setup(){
		initialization("/javascript_alerts");
		javaScriptAlertPage = new JavaScriptAlertPage();
	}
	
	@Test(priority = 1)
	public void loginSuccessTest() {
		String  actual = javaScriptAlertPage.alertMsg();
		Assert.assertEquals(actual, "I am a JS Alert");
	}

}
