package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class DragAndDropTest extends BaseTest{
	//Initializing page classes
	TestPage otherTests ;
	
	@Test
	public void dragAndDropTest() {
		System.out.println("Test4: Drag and Drop");
		otherTests = new TestPage(driver);
		otherTests.dragAndDrop();
	}
}
