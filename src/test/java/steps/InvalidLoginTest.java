package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class InvalidLoginTest extends CommonMethods {

	@Given("I enter valid name and invalid password and click login")
	public void i_enter_valid_name_and_password() {

		BaseClass dr = new BaseClass();

		dr.driver.get(ConfigsReader.getProperty("url") + "/login");

		wait(1);
		sendText(loginPage.userName, ConfigsReader.getProperty("username"));
		wait(1);
		sendText(loginPage.userPassword, "Test@123");
		wait(1);
		click(loginPage.loginButton);
	}

	@Then("I validate user was not able to log in")
	public void i_validate_user_was_not_able_to_log_in() {

		waitForVisibility(loginPage.invalidLogin);

		Assert.assertTrue("Uh-oh!!! User was able to login with invalid credentials...",
				loginPage.invalidLogin.isDisplayed());
		System.out.println("User was not able to login!");
	}

}
