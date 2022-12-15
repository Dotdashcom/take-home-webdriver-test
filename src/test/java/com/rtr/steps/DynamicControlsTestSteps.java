package com.rtr.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rtr.Pages.DynamicControlsElements;
import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DynamicControlsTestSteps extends CommonMethods {

	@Given("I navigated to Dynamic Controls website")
	public void i_navigated_to_dynamic_controls_website() {
		setUp("/dynamic_controls");
	}

	@Then("I click to remove button with explicit wait")
	public void i_click_to_remove_button_with_explicit_wait() {

		click(dynamicctrl.raButton);

	}

	@Then("I asserts that the checkbox is gone")
	public void i_asserts_that_the_checkbox_is_gone() {

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicctrl.msg));

		waitForVisibility(dynamicctrl.msg);

		String expectedmsg = "It's gone!";

		String actualmsg = dynamicctrl.msg.getText();

		Assert.assertEquals(expectedmsg, actualmsg);

	}

	@Then("I click to add button with explicit wait")
	public void i_click_to_add_button_with_explicit_wait() {
		click(dynamicctrl.raButton);
	}

	@Then("I asserts that the checkbox is present")
	public void i_asserts_that_the_checkbox_is_present() {
		waitForVisibility(dynamicctrl.checkbox);
		
		Assert.assertTrue(dynamicctrl.checkbox.isEnabled());
	}

	@Then("I click to Enable button with explicit wait")
	public void i_click_to_enable_button_with_explicit_wait() {
		click(dynamicctrl.edButton);
	}

	@Then("I asserts that the text box is enabled")
	public void i_asserts_that_the_text_box_is_enabled() {

		waitForVisibility(dynamicctrl.msg);

		String expectedmsg = "It's enabled!";

		String actualmsg = dynamicctrl.msg.getText();

		Assert.assertEquals(expectedmsg, actualmsg);

	}

	@Then("I click to Disable button with explicit wait")
	public void i_click_to_disable_button_with_explicit_wait() {

		click(dynamicctrl.edButton);
	}

	@Then("I asserts that the text box is disabled")
	public void i_asserts_that_the_text_box_is_disabled() {

		waitForVisibility(dynamicctrl.msg);

		String expectedmsg = "It's disabled!";

		String actualmsg = dynamicctrl.msg.getText();

		Assert.assertEquals(expectedmsg, actualmsg);
	}
}
