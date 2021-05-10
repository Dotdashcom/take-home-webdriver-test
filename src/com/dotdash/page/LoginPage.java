package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/login";
	private WebElement userNameInput;
	private WebElement passwordInput;
	private WebElement loginButton;
	private WebElement invalidCreadentialsMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		userNameInput = driver.findElement(By.id("username"));
		assertTrue(userNameInput.isDisplayed());
		assertTrue(userNameInput.isEnabled());

		passwordInput = driver.findElement(By.id("password"));
		assertTrue(passwordInput.isDisplayed());
		assertTrue(passwordInput.isEnabled());
		
		loginButton = driver.findElement(By.className("radius"));
		assertTrue(loginButton.isDisplayed());
		assertTrue(loginButton.isEnabled());
	}
	
	public void verifyLoginFailure() {
		verifyPage();
		invalidCreadentialsMessage = driver.findElement(By.cssSelector("div[class='flash error']"));
		assertTrue(invalidCreadentialsMessage.isDisplayed());
	}
	
	public SecureAreaPage login(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new SecureAreaPage(driver);
	}
	
	public LoginPage loginAndExpectFailure(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new LoginPage(driver);
	}
}
