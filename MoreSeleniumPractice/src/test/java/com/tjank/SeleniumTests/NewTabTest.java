package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.NewTabPage;
import com.tjank.PageObjectModel.WebPage;

public class NewTabTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void newTabTest() {
		NewTabPage tabPage = new NewTabPage();
		tabPage.setup();
		tabPage.waitForPageToLoad();
		tabPage.clickLink();
		tabPage.switchToNewTab();
		tabPage.verifyNewTabOpened();
	}
}
