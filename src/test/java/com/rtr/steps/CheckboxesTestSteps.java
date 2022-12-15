package com.rtr.steps;

import org.openqa.selenium.WebElement;

import com.rtr.testbase.BaseClass;
import com.rtr.utils.CommonMethods;
import com.rtr.utils.ConfigsReader;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class CheckboxesTestSteps extends CommonMethods{

	@Given("I navigated to CheckBox website")
	public void i_navigated_to_check_box_website() {
		setUp("/checkboxes");
	}
	@When("I check the checkboxes")
	public void i_check_the_checkboxes() {
	    
		for (WebElement element : checkbox.checkBoxes) {
			if(!element.isSelected())
				element.click();
		}
	}
	@Then("I validate that checkboxes are checked")
	public void i_validate_that_checkboxes_are_checked() {
		for (WebElement element : checkbox.checkBoxes) {
			Assert.assertTrue(element.isSelected());
		}
	}
	@When("I uncheck the checkBoxes")
	public void i_uncheck_the_check_boxes() {
		for (WebElement element : checkbox.checkBoxes) {
			if(element.isSelected())
				element.click();
		}
	}
	@Then("I validate that checkboxes are unchecked")
	public void i_validate_that_checkboxes_are_unchecked() {
		for (WebElement element : checkbox.checkBoxes) {
			Assert.assertEquals(element.isSelected(),false);
		}
	}
}
