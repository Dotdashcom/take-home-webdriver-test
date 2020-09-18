package stepDefs;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.LoginPage;
import utils.Driver;


public class LoginSuccess {
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		
		Driver.getDriver().get("http://localhost:7080/login");
		
	}

	@When("I enter username  {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		
		LoginPage loginpage= new LoginPage();
		loginpage.userid.sendKeys(username);
		loginpage.userpassword.sendKeys(password);
		loginpage.loginbutton.click();
//
		
	}

	@Then("I varify welcome message")
	public void i_varify_welcome_message() {
		
		LoginPage loginpage= new LoginPage();
		String expectedtextsuccess = "Welcome to the Secure Area. When you are done click logout below.";
		String actualtextsuccess = loginpage.actualtext.getText();
		Assert.assertEquals( expectedtextsuccess, actualtextsuccess);
	}
	
	@When("I enter invalid  username  {string} and password {string}")
	public void i_enter_invalid_username_and_password(String username, String password) {
		
		LoginPage loginpage= new LoginPage();
		loginpage.userid.sendKeys(username);
		loginpage.userpassword.sendKeys(password);
		loginpage.loginbutton.click();

	}

	@Then("I varify  message for invalid log in entry")
	public void i_varify_message_for_invalid_log_in_entry() {
		
		String expectedtextfail = "Your username is invalid!";
		LoginPage loginpage= new LoginPage();
		String actualtextfail = loginpage.actualtextforfailcase.getText();
		if(actualtextfail.contains(expectedtextfail)) {
			actualtextfail = expectedtextfail;
		}
		System.out.println(actualtextfail);
		Assert.assertEquals( expectedtextfail, actualtextfail);
		
	}


}
