package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.JavaScriptErrorPage;
import com.dotDash.page.NewTabPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewTabFeature_Test extends BaseTest{
	NewTabPage newTabPage;
	@Test(description = "Test to Validate New Tab Feature")
	void validateNewTabPage() throws InterruptedException, IOException {
		newTabPage=PageinstancesFactory.getInstance(NewTabPage.class);
		newTabPage.navigateToNewTabPage();
		newTabPage.validateNewTabFunctionality();
	}
}