package com.dotDash.page;

import com.dotDash.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.dotDash.page.common.BasePage;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class LoginPage extends BasePage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "#username")
	private WebElement userNameElement;

	@FindBy(css = "#password")
	private WebElement passwordElement;

	@FindBy(xpath = "//button//*[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
	private WebElement loginSuccessMessage;
	@FindBy(xpath = "//div[contains(text(),'You logged out of the secure area!')]")
	private WebElement logoutSuccessMessage;
	@FindBy(xpath = "//i[contains(text(),'Logout')]")
	private WebElement logoutButton;
	@FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
	private WebElement userNameError;
	@FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
	private WebElement userPasswordError;
	/**
	 * To check Login page 
	 * 
	 * @author Seb Geb
	 *
	 */
	public void checkLoginPage() {
		Assert.assertEquals(checkWebElementExist(loginButton), true);
	}
	/**
	 * To Login on Web App based on credentials passed
	 * @param sLoginID
	 * @param sLoginPassword
	 * @author Seb Geb
	 *
	 */
	
	public void login(String sLoginID, String sLoginPassword) {
		navigateTo(TestProperties.getProperty("LOGIN_URL"));
		checkLoginPage();
		setData(userNameElement, sLoginID);
		setData(passwordElement, sLoginPassword);
		clickOnElement(loginButton);
	}
	/**
	 * To Log out of App
	 * @author Seb Geb
	 *
	 */
	
	public void logout() {
		clickOnElement(logoutButton);
		checkLoginPage();
		Assert.assertEquals(checkWebElementExist(logoutSuccessMessage), true);
	}

	/**
	 * To Check Login Success Label exists
	 * @author Seb Geb
	 *
	 */
	public void checkLoginSuccessLabelExist() {
		Assert.assertEquals(checkWebElementExist(loginSuccessMessage), true);
	}
	/**
	 * To Check Login Failure Label exists
	 * @author Seb Geb
	 *
	 */
	public void checkLoginFailureLabelExist(String scenario) {
		if(scenario.equalsIgnoreCase("USERNAME"))
			Assert.assertEquals(checkWebElementExist(userNameError), true);
		else
			Assert.assertEquals(checkWebElementExist(userPasswordError), true);
	}
}
