package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.FileUploadPage;
import com.dotDash.page.FloatingMenuPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class FloatingMenuFeature_Test extends BaseTest{
	FloatingMenuPage floatingMenuPage;
	@Test(description = "Test to Validate Floating Menu Feature")
	void validatefloatingMenuPage() throws InterruptedException, IOException {
		floatingMenuPage=PageinstancesFactory.getInstance(FloatingMenuPage.class);
		floatingMenuPage.navigateToFloatinMenuPage();
		floatingMenuPage.validateFloatingMenuFeature();
	}
}