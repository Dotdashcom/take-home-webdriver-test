package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.DragDropPage;
import com.dotDash.page.DynamicContentPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicContentFeature_Test extends BaseTest{
	DynamicContentPage dynamicContentPage;
	@Test(description = "Test to Validate Dynamic Content Feature")
	void validateDynamicContent() throws InterruptedException, IOException {
		dynamicContentPage=PageinstancesFactory.getInstance(DynamicContentPage.class);
		dynamicContentPage.navigateToDynamicContentPage();
		dynamicContentPage.validateDynamicContentFeature();
	}
}