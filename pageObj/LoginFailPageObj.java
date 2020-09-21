package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class LoginFailPageObj extends Base {

	public LoginFailPageObj() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	private WebElement userName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	private WebElement passWord;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/button/i")
	private WebElement loginButton;

	

	public void enterWrongUserName(String WrongUsername ) {
		DriverUtility.enterText(userName, WrongUsername);
	}

	public void enterWrongPassword(String WrongPassword) {
		DriverUtility.enterText(passWord, WrongPassword);
	}

	public void clickonLoginButton() {
		loginButton.click();
	}

	
}
