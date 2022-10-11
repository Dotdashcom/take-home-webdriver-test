package com.tjank.SeleniumTests;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.DynamicContentPage;
import com.tjank.PageObjectModel.WebPage;

public class DynamicContentTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void dynamicContentTest() {
		DynamicContentPage contentPage = new DynamicContentPage();
		contentPage.setup();
		contentPage.waitForPageToLoad();
		ArrayList<String> list = contentPage.getTextCols();
		contentPage.refreshPage();
		contentPage.checkForDuplicateCols(list);
	}
}
