package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.DynamicControlsPage;
import com.dotDash.page.DynamicLoadingPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicLoadingFeature_Test extends BaseTest{
	DynamicLoadingPage dynamicLoadingPage;
	@Test(description = "Test to Validate Dynamic Loading Feature")
	void validatedynamicLoadingPage() throws InterruptedException, IOException {
		dynamicLoadingPage=PageinstancesFactory.getInstance(DynamicLoadingPage.class);
		dynamicLoadingPage.navigateToDynamicLoadingPage();
		dynamicLoadingPage.validateDynamicLoadingFeature();
	}
}