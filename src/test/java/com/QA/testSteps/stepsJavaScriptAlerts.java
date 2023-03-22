package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsJavaScriptAlerts extends CommonMethods {	
	
	@Given("click on JS Alert button and accept alert")
	public void click_on_JS_Alert_button_and_accept_alert() {
	    click(jsAlert.jsAlertBtn);
	    wait(1.0);
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshotRobot("testJavaScriptAlerts/alert1"), "image/png", AA_Hooks.scenario.getName());
	    acceptAlert();
	}

	@Then("verify alert message")
	public void verify_alert_message() {
	    AA_Hooks.softAssert.assertEquals(jsAlert.resultMessage.getText(), "You successfuly clicked an alert");
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testJavaScriptAlerts/alertMessage1"), "image/png", AA_Hooks.scenario.getName());
	}

	@Then("click on JS confirm button and click ok on alert")
	public void click_on_JS_confirm_button_and_click_ok_on_alert() {
	   click(jsAlert.jsConfirmBtn);
	   wait(1.0);
	   AA_Hooks.scenario.attach(CommonMethods.takeScreenshotRobot("testJavaScriptAlerts/alert2"), "image/png", AA_Hooks.scenario.getName());
	   acceptAlert();
	}
	
	@Then("verify new alert message")
	public void verify_new_alert_message() {
		AA_Hooks.softAssert.assertEquals(jsAlert.resultMessage.getText(), "You clicked: Ok");
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testJavaScriptAlerts/alertMessage2"), "image/png", AA_Hooks.scenario.getName());
	}

	@Then("click on JS Prompt button and type a message on Prompt")
	public void click_on_JS_Prompt_button_and_type_a_message_on_Prompt() {
	    click(jsAlert.jsPromptBtn);
	    sendTextToAlert("test JS Prompt");	
	    wait(1.0);
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshotRobot("testJavaScriptAlerts/alert3"), "image/png", AA_Hooks.scenario.getName());
	    acceptAlert();
	}

	@Then("verify that the alert message contains the typed message")
	public void verify_that_the_alert_message_contains_the_typed_message() {
		AA_Hooks.softAssert.assertEquals(jsAlert.resultMessage.getText(), "You entered: test JS Prompt");
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testJavaScriptAlerts/alertMessage3"), "image/png", AA_Hooks.scenario.getName());
	}



}
