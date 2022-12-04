package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;

import java.io.IOException;

public class LoginPage extends AbstractE2E {
	WebDriver driver;


	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='flash-messages']")
	private WebElement errorMessage;

	@FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area.')]")
	private WebElement welcomeHeader;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	private WebElement logoutButton;

	// methods on the page
	private void enterUsername(String userName) {
		username.clear();
		username.sendKeys(userName);
	}

	private void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	private void clickOnLoginButton() {
		submitButton.click();
	}

	public void login(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		clickOnLoginButton();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public boolean isHeaderDisplayed(int timeoutInSeconds) {
		boolean isHeader = false;
		try {
			testHandler.waitForElementToBeVisible(welcomeHeader, timeoutInSeconds);
			isHeader = welcomeHeader.isDisplayed();
		} catch (Exception e) {

		}
		return isHeader;
	}

	public boolean isHeaderDisplayed(long timeoutInMillis) {
		boolean isHeader = false;
		try {
			testHandler.waitForElementToBeVisible(welcomeHeader, timeoutInMillis);
			isHeader = welcomeHeader.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isHeader;
	}
	public void logout() {
		testHandler.waitForElementToBeClickable(logoutButton);
		logoutButton.click();
	}

	// get url
	public LoginPage getUrl() throws IOException {
		driver.navigate().to( url+ "/login");
		return this;
	}
}
