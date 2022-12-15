package com.rtr.steps;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class DynamicLoadingTestSteps extends CommonMethods{
	
	@Given("I navigated to Dynamic Loading website")
	public void i_navigated_to_dynamic_loading_website() {
		setUp("/dynamic_loading/2");
	}

	@Then("I click to start button with explicit wait")
	public void i_click_to_start_button_with_explicit_wait() {
	   jsClick(dynamicload.startBttn);
	}

	@Then("I asserts that Hello World text is displayed")
	public void i_asserts_that_hello_world_text_is_displayed() {
		
		waitForVisibility(dynamicload.hwmsg);

		String expectedmsg = "Hello World!";

		String actualmsg = dynamicload.hwmsg.getText();
		
		Assert.assertEquals(expectedmsg,actualmsg);

		
	}

}
