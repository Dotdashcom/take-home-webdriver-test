package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.IFramePage;
import com.dotDash.page.MouseHovePage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class MouseHoverFeature_Test extends BaseTest{
	MouseHovePage mouseHovePage;
	@Test(description = "Test to Validate Floating Menu Feature")
	void validatefloatingMenuPage() throws InterruptedException, IOException {
		mouseHovePage=PageinstancesFactory.getInstance(MouseHovePage.class);
		mouseHovePage.navigateToHoverPage();
		mouseHovePage.validateFloatingMenuFeature();
	}
}