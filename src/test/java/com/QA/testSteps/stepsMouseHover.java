package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Then;

public class stepsMouseHover extends CommonMethods {	
	
	@Then("do a mouse hover on {string} image")
	public void do_a_mouse_hover_on_image(String string) {
	    getActionsObj().moveToElement(mouse.images.get(Integer.parseInt(string)-1)).perform();
	}

	@Then("verify that additional information is displayed for {string} image")
	public void verify_that_additional_information_is_displayed_for_image(String string) {
	    AA_Hooks.softAssert.assertEquals(mouse.additionalInfo.get(Integer.parseInt(string)-1).getText().split("\n")[0], "name: user"+string);
	}


}
