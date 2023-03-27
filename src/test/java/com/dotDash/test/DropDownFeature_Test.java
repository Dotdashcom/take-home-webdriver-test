package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.CheckboxPage;
import com.dotDash.page.DropDownPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

public class DropDownFeature_Test extends BaseTest{
	DropDownPage dropDownPage;
	@Test(description = "Test to Validate Drop Down Feature")
	void validateDropDown(){
		dropDownPage=PageinstancesFactory.getInstance(DropDownPage.class);
		dropDownPage.navigateToDropDownPage();
		dropDownPage.validateDropDownFeature();
	}
}