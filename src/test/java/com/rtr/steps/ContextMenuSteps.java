package com.rtr.steps;

import javax.swing.Action;
import javax.swing.Box;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContextMenuSteps extends CommonMethods {

	@Given("I navigated to Context Menu website")
	public void i_navigated_to_context_menu_website() {
		setUp("/context_menu");
	}

	@When("I rigt click the box")
	public void i_rigt_click_the_box() {
	    
		Actions action = new Actions(driver);
		action.contextClick(context.box).perform();
	    wait(2);
	}

	@Then("I assert the alert menu text")
	public void i_assert_the_alert_menu_text() {
	   	
		
		String actualTxt = getAlertText();
		String expectedTxt = "You selected a context menu";
		acceptAlert();
		
		Assert.assertEquals(expectedTxt, actualTxt);
	}
	
}
