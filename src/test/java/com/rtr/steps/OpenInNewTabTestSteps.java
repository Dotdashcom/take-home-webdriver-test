package com.rtr.steps;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OpenInNewTabTestSteps extends CommonMethods {

	@Given("I navigated to Open in New Tab website")
	public void i_navigated_to_open_in_new_tab_website() {
	    setUp("/windows");
	}

	@Then("I clicks on the Click Here link")
	public void i_clicks_on_the_click_here_link() {
	    click(newtab.clickhere);
	}

	@Then("I asserts that a new tab is opened with text New Window")
	public void i_asserts_that_a_new_tab_is_opened_with_text_new_window() {
	   
		Set<String> allWindows = driver.getWindowHandles();
	   
	    Iterator<String> it = allWindows.iterator();
	    String window1 = it.next();
	    String window2 = it.next();
	    
	    driver.switchTo().window(window2);
	    wait(1);
	    
	    String expectedTxt = "New Window";
	    String actualTxt = newtab.newwindowtxt.getText();
	    
	    Assert.assertEquals(expectedTxt, actualTxt);
	}
}
