package com.dotDash.tests;

import org.testng.annotations.Test;
import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class CheckboxesTest extends BaseTest{
	
	//Initializing page classes
	TestPage otherTests ;
	
	@Test()
	public void verifyCheckbox1() {
		System.out.println("Test3: Check and Unckeck Boxes");
		otherTests = new TestPage(driver);
		
		// this is to check first time
		otherTests.verifyCheckbox("box1");
		otherTests.clickCheckbox("box1");
		// this is to check second time after click the checkbox.
		otherTests.verifyCheckbox("box1");
		
	} 
	
	@Test()
	public void verifyCheckbox2() {
		otherTests = new TestPage(driver);
		// verify the checkbox2 is checked.
		
		// verify the checkbox2 is unchecked.
		// this is to check first time
				otherTests.verifyCheckbox("box2");
				otherTests.clickCheckbox("box2");
				// this is to check second time after click the checkbox.
				otherTests.verifyCheckbox("box2");
				
		
	}

}
