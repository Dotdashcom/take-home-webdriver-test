package com.rtr.steps;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class MouseHoverTestSteps extends CommonMethods {
	
	@Given("I navigated to Mouse Hover website")
	public void i_navigated_to_mouse_hover_website() {
	   setUp("/hovers");
	}

	@Then("I hover mouse on each image to test for information is displayed for each image")
	public void i_hover_mouse_on_each_image_to_test_for_information_is_displayed_for_each_image() {
		
		Actions action = new Actions(driver);
		action.moveToElement(mousehover.photoone).build().perform();
		
		String expectedTxt1 = "name: user1";
		String actualtxt1 = mousehover.user1.getText();
		
		Assert.assertEquals(expectedTxt1, actualtxt1);
		
		wait(1);
		
		action.moveToElement(mousehover.phototwo).build().perform();
		
		String expectedTxt2 = "name: user2";
		String actualtxt2 = mousehover.user2.getText();
		
		Assert.assertEquals(expectedTxt2, actualtxt2);
		
        wait(1);
        
        action.moveToElement(mousehover.photothree).build().perform();
		
		String expectedTxt3 = "name: user3";
		String actualtxt3 = mousehover.user3.getText();
		
		Assert.assertEquals(expectedTxt3, actualtxt3);
		wait(1);
		
		
	}
	   
	 

}
