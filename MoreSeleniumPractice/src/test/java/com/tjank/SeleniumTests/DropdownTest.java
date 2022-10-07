package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.DropdownPage;
import com.tjank.PageObjectModel.WebPage;

public class DropdownTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void dropdownTest() {
		DropdownPage dropdownPage = new DropdownPage();
		dropdownPage.setup();
		dropdownPage.waitForPageToLoad();
		dropdownPage.selectDropdownOption("Option 1");
		dropdownPage.selectDropdownOption("Option 2");
	}
}
