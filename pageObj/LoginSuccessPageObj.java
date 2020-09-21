package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class LoginSuccessPageObj extends Base {

	public LoginSuccessPageObj() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	private WebElement userName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	private WebElement passWord;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/button/i")
	private WebElement loginButton;

	

	public void enterUserName(String username ) {
		DriverUtility.enterText(userName, username);
	}

	public void enterPassword(String password) {
		DriverUtility.enterText(passWord, password);
	}

	public void clickonLoginButton() {
		loginButton.click();
	}
}
