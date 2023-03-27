package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.JavaScriptAlertsPage;
import com.dotDash.page.MouseHovePage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class JavaScriptAlertsFeature_Test extends BaseTest{
	JavaScriptAlertsPage javaScriptAlertsPage;
	@Test(description = "Test to Validate JS Alerts Feature")
	void validateJSAlertFeature() throws InterruptedException, IOException {
		javaScriptAlertsPage=PageinstancesFactory.getInstance(JavaScriptAlertsPage.class);
		javaScriptAlertsPage.navigateToHoverPage();
		javaScriptAlertsPage.validateJSAlertFeature();
		javaScriptAlertsPage.validateJSConfirmFeature();
		javaScriptAlertsPage.validateJSPromptFeature();
	}
}