package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewlyOpenedWindowPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/windows/new";
	private WebElement header;

	public NewlyOpenedWindowPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		header = driver.findElement(By.tagName("h3"));
		assertTrue(header.isDisplayed());
		assertEquals(header.getText(), "New Window");
	}
}
