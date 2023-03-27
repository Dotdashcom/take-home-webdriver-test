package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.CheckboxPage;
import com.dotDash.page.LoginPage;
import com.dotDash.page.common.PageinstancesFactory;
import com.dotDash.utils.TestProperties;
import org.testng.annotations.Test;

public class CheckboxFeature_Test extends BaseTest{
	CheckboxPage checkboxPage;
	@Test(description = "Test to Validate Checkbox Feature")
	void validateCheckboxes(){
		checkboxPage=PageinstancesFactory.getInstance(CheckboxPage.class);
		checkboxPage.navigateToCheckboxPage();
		checkboxPage.validateCheckbox();
	}
}