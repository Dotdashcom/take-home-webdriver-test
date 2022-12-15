package com.rtr.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class JavaScriptAlertsTestSteps extends CommonMethods {
	
	@Given("I navigated to JavaScript Alerts website")
	public void i_navigated_to_java_script_alerts_website() {
	    setUp("/javascript_alerts");
	}

	@Then("I Clicks on JS Alert Button")
	public void i_clicks_on_js_alert_button() {
	    click(jsalerts.jsalert);
	    wait(1);
	    
	    
	}

	@Then("I assert alert message")
	public void i_asserts_alert_message() {
		
		String expectedTxt = "I am a JS Alert";
		String actualTxt = getAlertText();
		Assert.assertEquals(expectedTxt, actualTxt);
		acceptAlert();
		wait(1);
	}

	@Then("I clicks on JS confirm Button and clicks ok on alert")
	public void i_clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
		click(jsalerts.jsconfirm);
	    wait(1);
	}

	@Then("I assert the alert message")
	public void i_asserts_the_alert_message() {
	    
		String expectedTxt = "I am a JS Confirm";
		String actualTxt = getAlertText();
		Assert.assertEquals(expectedTxt, actualTxt);
		acceptAlert();
		
	}

	@Then("I clicks on JS Prompt Button and types a message on Prompt")
	public void i_clicks_on_js_prompt_button_and_types_a_message_on_prompt() {
		
		click(jsalerts.jsprompt);
		wait(1);
	    sendAlertText("This is a test text");
	    acceptAlert();
	}

	@Then("I assert that the alert message contains the typed message")
	public void i_asserts_that_the_alert_message_contains_the_typed_message() {
		
		Assert.assertEquals(jsalerts.result.getText(), "You entered: This is a test text");
	}

}
