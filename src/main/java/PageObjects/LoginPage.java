package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class LoginPage extends BrowserUtilities {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement uname;

	@FindBy(how = How.ID, using = "password")
	WebElement pwd;

	@FindBy(how = How.XPATH, using = "//*[text()=' Login']")
	WebElement btn_login;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),' Logout')]")
	WebElement btn_logout;

	@FindBy(how = How.ID, using = "flash")
	WebElement alertMessage;

	public void getUrl() {
		driver.get(BaseTest.getURL("login"));
	}

	public void enterUserName(String name) {
		fnSetTextInTextBox(name, "username_field", uname);
	}

	public void enterPassword(String pword) {
		fnSetTextInTextBox(pword, "username_field", pwd);
	}

	public void clickSignIn() {
		Click(btn_login);
	}

	public boolean verifyLogout() {
		fnExplictWaitOfElement(BaseTest.driver,btn_logout);
		return isElementPresent(btn_logout, "logout button");
	}

	public String readMessage() {
		fnExplictWaitOfElement(BaseTest.driver,alertMessage);
		return getText(alertMessage);
	}

}
