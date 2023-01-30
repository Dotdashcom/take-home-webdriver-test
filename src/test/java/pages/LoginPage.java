package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.BaseTest;

public class LoginPage extends BaseTest {

	private By userName_input = By.id("username");
	private By password_input = By.id("password");
	private By login_btn = By.cssSelector("button[type='submit']");
	private By welcome_message = By.className("subheader");
	private By error_message = By.id("flash");

	public void loginToWebTestLoginPage(String userName, String password) {
		driver.findElement(userName_input).sendKeys(userName);
		driver.findElement(password_input).sendKeys(password);
		driver.findElement(login_btn).click();
	}

	public void assertLoginSuccessfull(String expectedMessage) {
		Assert.assertEquals(driver.findElement(welcome_message).getText().trim(), expectedMessage,
				"Welcome message verification");
	}

	public void assertLoginFailed(String expectedMessage) {
		Assert.assertEquals(driver.findElement(error_message).getText().trim(), expectedMessage,
				"Error message verification");
	}

}
