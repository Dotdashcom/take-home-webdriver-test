package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.DynamicControlsPage;
import com.tjank.PageObjectModel.WebPage;

public class DynamicControlsTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void dynamicControlsTest() {
		DynamicControlsPage dynPage = new DynamicControlsPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickRemoveButton();
		dynPage.clickAddButton();
		dynPage.clickEnableButton();
		dynPage.clickDisableButton();
	}
}
