package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.ContextMenuPage;
import com.tjank.PageObjectModel.WebPage;

public class ContextMenuTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void contextMenuTest() {
		ContextMenuPage contextMenuPage = new ContextMenuPage();
		contextMenuPage.setup();
		contextMenuPage.waitForPageToLoad();
		contextMenuPage.rightClickContextMenu();
		contextMenuPage.waitForAlertToDisplay();
		contextMenuPage.verifyAlertText();
	}
	
}
