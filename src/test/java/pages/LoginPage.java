package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.TestUtility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;

	@FindBy(xpath = "//div[@id='flash']")
	private WebElement errorText;

	@FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area.')]")
	private WebElement welcomeHeader;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	private WebElement logout;

	// methods on the page
	public void enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void clickOnLoginButton() {
		login.click();
	}

	public void loginToApp(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickOnLoginButton();
	}

	public String getErrorText() {
		return errorText.getText().trim();
	}

	public boolean isHeaderDisplayed() {
		boolean isHeader = false;
		try {
			TestUtility.waitForElement(welcomeHeader, 20);
			isHeader = welcomeHeader.isDisplayed();
		} catch (Exception e) {

		}
		return isHeader;
	}

	public void logout() {
		TestUtility.waitForElementClickable(logout);
		logout.click();
	}

	// get url
	public LoginPage getUrl() {
		driver.navigate().to(TestBase.url + "/login");
		return this;
	}
}
