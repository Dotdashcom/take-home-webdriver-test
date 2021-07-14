package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FloatingMenuPage extends BasePage {

	WebDriver obj_Driver;
	String title = "//h3[text()='Floating Menu']";

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(title);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(title)).size() > 0, "Floating Menu title page is displayed");
	}

	public void floatingMenu() {
		scrollDown();
		Assert.assertTrue(true, "Page scrolled down Succesfully");
	}

}
