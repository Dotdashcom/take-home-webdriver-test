package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicLoadingPage extends BasePage {

	WebDriver obj_Driver;
	String dynamicLoadingTitle = "//h3[text()='Dynamically Loaded Page Elements']";
	String startButton = "//div[@id='start']/button";
	String message = "//h4[text()='Hello World!']";

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(dynamicLoadingTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(dynamicLoadingTitle)).size() > 0,
				"dynamic Loading  page is displayed");
	}

	public void clickStart() {
		click(startButton, "Start button");

	}

	public void verifyText() {
		explicitWait(message);
		isDisplayedAssert(message, "Hello world message");
	}

}
