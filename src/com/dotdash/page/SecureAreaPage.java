package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage extends AbstractPage {

	private WebElement logoutButton;

	public SecureAreaPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		logoutButton = driver.findElement(By.cssSelector("a[class='button secondary radius']"));
		assertTrue(logoutButton.isDisplayed());
		assertTrue(logoutButton.isEnabled());
	}

	public LoginPage logout() {
		logoutButton.click();
		return new LoginPage(driver);
	}
}
