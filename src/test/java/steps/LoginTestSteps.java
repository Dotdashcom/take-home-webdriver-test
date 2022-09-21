package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class LoginTestSteps extends CommonMethods {
	
	@Given("I enter valid name and password and click login")
	public void i_enter_name_and_password() {
	   
		BaseClass dr = new BaseClass();
		
		dr.driver.get(ConfigsReader.getProperty("url") + "/login");
		
		wait(1);
		sendText(loginPage.userName, ConfigsReader.getProperty("username"));
		wait(1);
		sendText(loginPage.userPassword, ConfigsReader.getProperty("password"));
		wait(1);
		click(loginPage.loginButton);		
	}
	
	@Then("I validate user is logged in")
	public void i_validate_user_is_logged_in() {
		
		waitForVisibility(loginPage.successLogin);

		Assert.assertTrue("User was not loged in...", loginPage.successLogin.isDisplayed());
		System.out.println("User has successfully logged in!");
	}

}
