package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.MouseHoverPage;
import com.tjank.PageObjectModel.WebPage;

public class MouseHoverTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void hoverTest() {
		MouseHoverPage hoverPage = new MouseHoverPage();
		hoverPage.setup();
		hoverPage.waitForPageToLoad();
		hoverPage.verifyImageText(hoverPage.getImages());
	}
}
