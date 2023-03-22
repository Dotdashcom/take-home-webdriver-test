package com.QA.testSteps;


import com.QA.BaseUtils.CommonMethods;
import com.QA.BaseUtils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsLogin extends CommonMethods {
	
	@Given("navigate to the {string} page")
	public void navigate_to_page(String string) {
	    driver.get(ConfigsReader.getProperty("BaseUrl").concat(string));
	}

	@Then("verify login was successful")
	public void verify_login_was_successful() {
	    sendText(login.username, "tomsmith");
	    sendText(login.password, "SuperSecretPassword!");
	    click(login.loginBtn);
	    AA_Hooks.softAssert.assertEquals(login.flashMessage.getText().split("\n")[0], "You logged into a secure area!");
	}

	@Then("verify the error message for an invalid username")
	public void verify_the_error_message_for_an_invalid_username() {
		sendText(login.username, "ngdhnghn");
	    sendText(login.password, "SuperSecretPassword");
	    click(login.loginBtn);
	    AA_Hooks.softAssert.assertEquals(login.flashMessage.getText().split("\n")[0], "Your username is invalid!"); 	    
	}

	@Then("verify the error message for an invalid password")
	public void verify_the_error_message_for_an_invalid_password() {
		sendText(login.username, "tomsmith");
	    sendText(login.password, "ghngfn");
	    click(login.loginBtn);
	    AA_Hooks.softAssert.assertEquals(login.flashMessage.getText().split("\n")[0], "Your password is invalid!");	 
	}

}
