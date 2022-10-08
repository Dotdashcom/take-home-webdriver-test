package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class LoginPage extends PageObjectBase {

	public LoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public LoginPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public LoginPage enterUserName(String username) {

		WebElement usernameField = this.getDriver().findElement(By.xpath("//input[@id='username']"));
		usernameField.sendKeys(username);

		return this;
	}

	public LoginPage enterPassword(String password) {

		WebElement passwordField = this.getDriver().findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys(password);

		return this;
	}

	public LoginPage clickLoginButton() {

		WebElement loginButton = this.getDriver().findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
		loginButton.click();

		return this;
	}

	public String errorMessage() {

		WebElement message = this.getDriver().findElement(By.xpath("//div[@class='flash error']"));
		String errorMessage = message.getText();

		System.out.println(errorMessage);

		return errorMessage;
	}

	@Override
	protected String getRelativeUrl() {
		return "/login";
	}

}
