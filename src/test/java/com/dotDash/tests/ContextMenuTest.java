package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class ContextMenuTest extends BaseTest{

	//Initializing page classes
	TestPage otherTests; 
	
	@Test
	public void contextMenu() {
		otherTests = new TestPage(driver);
		otherTests.rightClickOnContextMenu();
	}
}
