package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class CheckboxPage extends BasePage {
	private WebDriver driver;

	public CheckboxPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Checkboxes']")
	private WebElement checkboxesHeader;
	@FindBy(xpath = "//*[@id='checkboxes']/input[1]")
	private WebElement checkbox1;
	@FindBy(xpath = "//*[@id='checkboxes']/input[2]")
	private WebElement checkbox2;
	/**
	 * To check Checkbox page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToCheckboxPage() {
		navigateTo(TestProperties.getProperty("CHECKBOX_URL"));
		Assert.assertEquals(checkWebElementExist(checkboxesHeader), true);
	}
	/**
	 * To Validate Checkboxes functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateCheckbox() {
		Assert.assertEquals(getWebElementAttribute(checkbox1,"checked"), null);
		clickOnElement(checkbox1);
		Assert.assertEquals(getWebElementAttribute(checkbox1,"checked"), "true");

		Assert.assertEquals(getWebElementAttribute(checkbox2,"checked"), "true");
		clickOnElement(checkbox2);
		Assert.assertEquals(getWebElementAttribute(checkbox2,"checked"), null);
	}
}
