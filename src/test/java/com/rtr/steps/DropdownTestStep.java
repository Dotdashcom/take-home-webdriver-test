package com.rtr.steps;


import org.apache.bcel.generic.DDIV;
import org.openqa.selenium.support.ui.Select;

import com.rtr.Pages.DropdownPageElenments;
import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class DropdownTestStep extends CommonMethods {

	
	@Given("I navigated to Dropdown website")
	public void i_navigated_to_dropdown_website() {
	    setUp("/dropdown");
	}

	@Then("I selected dropdown Option1")
	public void i_selected_dropdown_option1() {
		selectDropdown(dropdown.dpdown,1);
	}

	@Then("I assert Option1 is selected")
	public void i_assert_option1_is_selected() {
		Select dd = new Select(DropdownPageElenments.dpdown);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(),"Option 1"); 
		
	}

	@Then("I selected dropdown Option2")
	public void i_selected_dropdown_option2() {
		selectDropdown(dropdown.dpdown,2);
	}

	@Then("I assert Option2 is selected")
	public void i_assert_option2_is_selected() {
		Select dd = new Select(DropdownPageElenments.dpdown);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(),"Option 2");   
	}

}
