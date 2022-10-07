package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.FloatingMenuPage;
import com.tjank.PageObjectModel.WebPage;

public class FloatingMenuTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void floatingMenutest() {
		FloatingMenuPage fmPage = new FloatingMenuPage();
		fmPage.setup();
		fmPage.waitForPageToLoad();
		fmPage.scrollDown();
		fmPage.verifyFloatMenu();
	}
}
