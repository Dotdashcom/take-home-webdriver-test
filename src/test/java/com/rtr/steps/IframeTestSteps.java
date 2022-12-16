package com.rtr.steps;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class IframeTestSteps extends CommonMethods {

	@Given("I navigated to Iframe website")
	public void i_navigated_to_iframe_website() {
	    setUp("/iframe");
	}

	@Then("I  switches to Iframe and types some text")
	public void i_switches_to_iframe_and_types_some_text() {
	  driver.switchTo().frame(iframe.frame1);
	  iframe.txtContent.clear();
	  sendText(iframe.txtContent, "Test for Iframe");
	}

	@Then("assert that the typed text is as expected")
	public void assert_that_the_typed_text_is_as_expected() {
	  Assert.assertEquals(iframe.txtContent.getText(), "Test for Iframe"); 
	}
}
