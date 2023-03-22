package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsDynamicLoading extends CommonMethods {
	
	@Given("click the start button")
	public void click_the_start_button() {
	    click(dynamicLoading.startBtn);
	}

	@Then("verify that {string} text is displayed")
	public void verify_that_text_is_displayed(String string) {
	    waitForVisibility(dynamicLoading.message);
	    AA_Hooks.softAssert.assertEquals(dynamicLoading.message.getText(), "Hello World!");
	}


}
