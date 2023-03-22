package com.QA.testSteps;

import java.util.concurrent.TimeUnit;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsDynamicControls extends CommonMethods {
	
	@Given("click on the Remove button")
	public void click_on_the_Remove_Button() {
	    click(dynamicControls.removeBtn);
	}

	@Then("verify that the checkbox is gone")
	public void verify_that_the_checkbox_is_gone() {
		waitForVisibility(dynamicControls.message);
	    AA_Hooks.softAssert.assertEquals(dynamicControls.message.getText(), "It's gone!");
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    AA_Hooks.softAssert.assertTrue(dynamicControls.checkbox.size()==0);	  
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testDynamicControls/the_checkbox_is_gone"), "image/png", AA_Hooks.scenario.getName());
	}

	@Then("click on Add button")
	public void click_on_Add_Button() {
		 click(dynamicControls.addBtn);
	}

	@Then("verify that the checkbox is present")
	public void verify_that_the_checkbox_is_present() {
		waitForVisibility(dynamicControls.message);
		waitForVisibility(dynamicControls.checkbox.get(0));
	    AA_Hooks.softAssert.assertEquals(dynamicControls.message.getText(), "It's back!");
	    AA_Hooks.softAssert.assertTrue(dynamicControls.checkbox.get(0).isDisplayed());
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testDynamicControls/the_checkbox_is_present"), "image/png", AA_Hooks.scenario.getName());
	}

	@Then("click on the Enable button")
	public void click_on_the_Enable_Button() {
		click(dynamicControls.enableBtn);
	}

	@Then("verify that the text box is enabled")
	public void verify_that_the_text_box_is_enabled() {
		waitForVisibility(dynamicControls.message);
		waitForClickability(dynamicControls.text);
	    AA_Hooks.softAssert.assertEquals(dynamicControls.message.getText(), "It's enabled!");
	    AA_Hooks.softAssert.assertTrue(dynamicControls.text.isEnabled());
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testDynamicControls/the_text_box_is_enabled"), "image/png", AA_Hooks.scenario.getName());
	}

	@Then("click on the Disable button")
	public void click_on_the_Disable_Button() {
		click(dynamicControls.disableBtn);
	}

	@Then("verify that the text box is disabled")
	public void verify_that_the_text_box_is_disabled() {
		waitForVisibility(dynamicControls.message);		
	    AA_Hooks.softAssert.assertEquals(dynamicControls.message.getText(), "It's disabled!");
	    AA_Hooks.softAssert.assertTrue(!dynamicControls.text.isEnabled());
	    AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testDynamicControls/the_text_box_is_disabled"), "image/png", AA_Hooks.scenario.getName());
	}

}
