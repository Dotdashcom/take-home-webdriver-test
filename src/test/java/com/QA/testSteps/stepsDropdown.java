package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;

public class stepsDropdown extends CommonMethods {	

	@Given("select {string} from the drop-down menu and verify it was selected")
	public void select_from_the_drop_down_menu_and_verify_it_was_selected(String string) {
	   selectDdValue(dropDown.dropdownDD, string);
	   AA_Hooks.softAssert.assertEquals(getSelectObject(dropDown.dropdownDD).getFirstSelectedOption().getText(), string);
	  
	}	

}
