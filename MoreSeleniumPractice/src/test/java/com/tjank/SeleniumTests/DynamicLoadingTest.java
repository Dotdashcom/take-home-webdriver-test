package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.DynamicLoadingPage;
import com.tjank.PageObjectModel.WebPage;

public class DynamicLoadingTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void dynamicLoadingTest() {
		DynamicLoadingPage dynPage = new DynamicLoadingPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickStartButton();
	}
}
