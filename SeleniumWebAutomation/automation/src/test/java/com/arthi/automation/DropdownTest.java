package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.DropdownPage;

public class DropdownTest extends TestBase {
	
	
	@Test()
	public void checkDropdownValues() {
		DropdownPage dropdownpage= new DropdownPage(getDriver());
		dropdownpage.navigateToDropDownPage()
		.selectValueFromDropDown("Option 1");
		
	}
	
	
	

}
