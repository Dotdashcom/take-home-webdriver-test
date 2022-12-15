package com.rtr.steps;

import org.openqa.selenium.JavascriptExecutor;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class FloatingMenuTestSteps extends CommonMethods {
	
	@Given("I navigated to Floating Menu website")
	public void i_navigated_to_floating_menu_website() {
	    setUp("/floating_menu");
	    wait(3);
	}

	@Then("I test scrolls the page until end.")
	public void i_test_scrolls_the_page_until_end() {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   wait(3);
	   
	}

	@Then("assert that the floating menu is still displayed")
	public void assert_that_the_floating_menu_is_still_displayed() {
		
		Assert.assertTrue(floatingMenu.floadmenu.isDisplayed());
	}

}
