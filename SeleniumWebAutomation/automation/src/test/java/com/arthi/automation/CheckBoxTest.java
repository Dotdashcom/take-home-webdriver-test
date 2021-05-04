package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.CheckBoxPage;

/**
 * 
 * @author Arthina Kumar
 *
 */


public class CheckBoxTest extends TestBase {
	
	
	@Test(description= "verify the check box is selected ")
	public void testcheckBoxIsselect() {
		CheckBoxPage checkboxPage = new CheckBoxPage(getDriver());
		checkboxPage.navigateToCheckBoxPage()
		.verifyCheckBoxSelect();
		
	}
	
	@Test(description= "verify the check box is selected ")
	public void testcheckBoxIsNotselect() {
		CheckBoxPage checkboxPage = new CheckBoxPage(getDriver());
		checkboxPage.navigateToCheckBoxPage()
		.verifyCheckBoxUnselect();
		
	}


}
