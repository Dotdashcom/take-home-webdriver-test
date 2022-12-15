package com.rtr.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.Console;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Sleeper;

import com.rtr.testbase.BaseClass;
import com.rtr.utils.CommonMethods;
import com.rtr.utils.ConfigsReader;

public class LoginFunctionalityTestSteps extends CommonMethods {

	
	@Given("I navigated to website")
	public void i_navigated_to_website() {
	   setUp("/login");
	}
	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
	    sendText(login.username,ConfigsReader.getPropertyFromProp("username"));
	}
	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
	  sendText(login.password, ConfigsReader.getPropertyFromProp("password")); 
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	     click(login.loginBtn); 
	}
	
	
	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String actualString = login.InvalidMsg.getText();
		String expectedString = "You logged into a secure area!";
		
		if(!actualString.contains(expectedString))
		{
			System.out.println("Test FAILED!");
		}else {
			System.out.println("Test PASSED!");
		}
		
		
	}
	
	@Then("I quit the browser")
	public void i_quit_the_browser() {
		BaseClass.tearDown();
	}
	
	
	
	@When("I enter a invalid password")
	public void i_enter_a_invalid_password() {
		sendText(login.password,"INVALID PASSWORD");
	}
	@Then("I validate that Invalid credentials message is displayed")
	public void i_validate_that_invalid_credentials_message_is_displayed() {
		String actualString = login.InvalidMsg.getText();
		String expectedString = "Your password is invalid!";
		
		if(!actualString.contains(expectedString))
		{
			System.out.println("Test FAILED!");
		}else {
			System.out.println("Test PASSED!");
		}
	}
	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
	    BaseClass.tearDown();
	}
	
	@When("I enter a invalid username")
	public void i_enter_a_invalid_username() {
	    sendText(login.username,"INVALID USERNAME");
	}

	@Then("I validate that Invalid Username message is displayed")
	public void i_validate_that_invalid_username_message_is_displayed() {
	    
		String actualString = login.InvalidMsg.getText();
		String expectedString = "Your username is invalid!";
		
		if(!actualString.contains(expectedString))
		{
			System.out.println("Test FAILED!");
		}else {
			System.out.println("Test PASSED!");
		}
	}
	
}
