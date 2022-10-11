package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.IFramePage;
import com.tjank.PageObjectModel.WebPage;

public class IFrameTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void iframeTest() {
		IFramePage frPage = new IFramePage();
		frPage.setup();
		frPage.waitForPageToLoad();
		frPage.clickXSymbol();
		frPage.typeText();
	}
}
