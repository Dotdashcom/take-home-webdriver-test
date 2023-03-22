package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsIframe extends CommonMethods {
	
	String text="test Iframe";
	
	@Given("switch to Iframe and types some text")
	public void switch_to_Iframe_and_types_some_text() {
	click(iframe.closeAlertBtn);
	switchToFrame(iframe.iframeElement);	
	sendText(iframe.textArea, text);
	}

	@Then("verify that the typed text is as expected")
	public void verify_that_the_typed_text_is_as_expected() {
	    AA_Hooks.softAssert.assertEquals(iframe.textArea.getText(), text);
	}


}
