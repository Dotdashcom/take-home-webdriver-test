package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class DynamicLoadingPage extends BasePage {
	private WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Dynamically Loaded Page Elements']")
	private WebElement dynamicLoading;
	@FindBy(xpath = "//button[text()='Start']")
	private WebElement startButton;
	@FindBy(xpath = "//h4[text()='Hello World!']")
	private WebElement helloWorldLabel;

	/**
	 * To check Dynamic Control page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToDynamicLoadingPage() {
		navigateTo(TestProperties.getProperty("DYNAMIC_LOADING_URL"));
		assertEquals("Dynamically Loaded Page Elements Header",checkWebElementExist(dynamicLoading), true);
	}
	/**
	 * To Validate DYNAMIC CONTROL functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDynamicLoadingFeature() {
		clickOnElement(startButton);
		waitForElementExistance(helloWorldLabel);
	}
}
