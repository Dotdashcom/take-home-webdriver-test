package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.FloatingMenuPage;
import com.dotDash.page.IFramePage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class IFrameFeature_Test extends BaseTest{
	IFramePage iFramePage;
	@Test(description = "Test to Validate IFRAME Feature")
	void validateiFramePage() throws InterruptedException, IOException {
		iFramePage=PageinstancesFactory.getInstance(IFramePage.class);
		iFramePage.navigateToIFramePage();
		iFramePage.validateFloatingMenuFeature();
	}
}