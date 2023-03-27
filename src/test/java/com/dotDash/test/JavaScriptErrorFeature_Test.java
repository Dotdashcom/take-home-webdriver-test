package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.JavaScriptAlertsPage;
import com.dotDash.page.JavaScriptErrorPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class JavaScriptErrorFeature_Test extends BaseTest{
	JavaScriptErrorPage javaScriptErrorPage;
	@Test(description = "Test to Validate JS Error Feature")
	void validateJSError() throws InterruptedException, IOException {
		javaScriptErrorPage=PageinstancesFactory.getInstance(JavaScriptErrorPage.class);
		javaScriptErrorPage.navigateToJSErrorPage();
		javaScriptErrorPage.validateJSErrorPage();
	}
}