package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsFloatingMenu extends CommonMethods {

	@Given("scroll the page")
	public void scroll_the_page() {
	    jsScrollDownToBottom();
	}

	@Then("verify the floating menu is still displayed")
	public void verify_the_floating_menu_is_still_displayed() {
	    AA_Hooks.softAssert.assertTrue(floatingMenu.floatingMenuElement.isDisplayed());
	}


}
