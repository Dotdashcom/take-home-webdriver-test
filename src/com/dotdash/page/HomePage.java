package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
	public static final String RELATIVE_PATH = "/";
	private WebElement heading;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
//		heading = new WebDriverWait(driver, WAIT_TIME).until(driver -> driver.findElement(By.className("heading")));
		heading = driver.findElement(By.className("heading"));
		assertTrue(heading.isDisplayed());
	}
}
