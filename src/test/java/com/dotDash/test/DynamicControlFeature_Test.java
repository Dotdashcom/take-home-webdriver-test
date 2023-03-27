package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.DynamicContentPage;
import com.dotDash.page.DynamicControlsPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicControlFeature_Test extends BaseTest{
	DynamicControlsPage dynamicControlsPage;
	@Test(description = "Test to Validate Dynamic Control Feature")
	void validateDynamicControl() throws InterruptedException, IOException {
		dynamicControlsPage=PageinstancesFactory.getInstance(DynamicControlsPage.class);
		dynamicControlsPage.navigateToDynamicContentPage();
		dynamicControlsPage.validateDynamicControlFeature();
	}
}