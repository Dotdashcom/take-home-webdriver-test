package com.theInternet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='start']/button")
	WebElement button_Start;

	@FindBy(xpath = "//*[@id='finish']/h4")
	WebElement text_Finish;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void VerifyDynamic_Loading_WithExplicitWait() {
		button_Start.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(text_Finish));
		Assert.assertTrue(text_Finish.getText().equalsIgnoreCase("Hello World!"),
				"text not displayed as expected.");
	}

}
