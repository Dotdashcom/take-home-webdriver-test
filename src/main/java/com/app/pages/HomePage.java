package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'success')]")
	private WebElement successLoginBar;
	
	@FindBy(xpath = "//i[contains(text(),'Logout')]/parent::a")
	private WebElement btnLogout;
	
	@FindBy(xpath = "//h4[@class='subheader']")
	private WebElement subHeader;
	
	public void verifyLogin() {
		assertTrue(successLoginBar.isDisplayed());
		String successMsg = successLoginBar.getText().replace("×", "").trim();
		assertEquals("You logged into a secure area!", successMsg);
		verifySubHeader();
		verifyBtnLogout();
	}
	
	private void verifyBtnLogout() {
		assertTrue(btnLogout.isEnabled());
	}
	
	private void verifySubHeader() {
		String expectedMsg = "Welcome to the Secure Area. When you are done click logout below.";
		assertEquals(expectedMsg, subHeader.getText().trim());
	}
	
}
