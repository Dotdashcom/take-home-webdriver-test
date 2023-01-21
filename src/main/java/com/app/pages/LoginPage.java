package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.util.ConfigReader;
import com.app.util.PageLinks;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement inputUserName;
	
	@FindBy(id = "password")
	private WebElement inputUserPassword;
	
	@FindBy(tagName = "button") //need to refactor
	private WebElement btnLogin;
	
	@FindBy(xpath = "//div[contains(@class, 'flash error')]")
	private WebElement errorFlashBar;
	
	//optimize it
	public void visitLoginPage() {
		
		getDriver().get(PageLinks.LOGIN_PAGE);
	}
	
	public void login() {
		verifyHeader();
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		inputUserName.sendKeys(username);
		inputUserPassword.sendKeys(password);
		btnLogin.click();
	}
	
	
	private void verifyHeader() {
		assertEquals("The Internet", getDriver().getTitle());
	}
	
	public void verifyInvalidLogin() {
		verifyHeader();
		String username = "WrongUser";
		String password = "WrongPass123";
		inputUserName.sendKeys(username);
		inputUserPassword.sendKeys(password);
		btnLogin.click();
		
		assertTrue(errorFlashBar.isDisplayed());
		String flashBarErrorTxt = errorFlashBar.getText().replace("×", "").trim();
		assertEquals("Your username is invalid!", flashBarErrorTxt);
	}
	
	
	
}
