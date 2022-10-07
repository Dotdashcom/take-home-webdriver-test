package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.DragAndDropPage;
import com.tjank.PageObjectModel.WebPage;

public class DragAndDropTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void dragAndDropTest() {
		DragAndDropPage dndPage = new DragAndDropPage();
		dndPage.setup();
		dndPage.waitForPageToLoad();
		dndPage.dragAndDrop();
		dndPage.verifyElementSwitch();
	}
}
