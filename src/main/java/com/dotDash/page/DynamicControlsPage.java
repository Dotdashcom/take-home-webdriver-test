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
public class DynamicControlsPage extends BasePage {
	private WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h4[text()='Dynamic Controls']")
	private WebElement dynamicControls;
	@FindBy(css = "input[label='blah']")
	private WebElement checkboxA;
	private By checkBoxALocator=By.xpath("input[label='blah']");
	private By checkBoxALocator_reappear=By.cssSelector("#checkbox");
	@FindBy(css = "#input-example > input")
	private WebElement enableDisableEditBox;
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement buttonRemove;
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement buttonAdd;
	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement buttonEnable;
	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement buttonDisable;

	/**
	 * To check Dynamic Control page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToDynamicContentPage() {
		navigateTo(TestProperties.getProperty("DYNAMIC_CONTROL_URL"));
		assertEquals("Dynamic Control Header",checkWebElementExist(dynamicControls), true);
	}
	/**
	 * To Validate DYNAMIC CONTROL functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDynamicControlFeature() {
		clickOnElement(buttonRemove);
		waitForElementNonExistance(checkBoxALocator);
		clickOnElement(buttonAdd);
		waitForElementExistance(checkBoxALocator_reappear);
		clickOnElement(buttonEnable);
		assertEquals("Editbox should be Enabled",getWebElementAttribute(enableDisableEditBox,"disabled"),"true");
		clickOnElement(buttonDisable);
		assertEquals("Editbox should be Disabled",getWebElementAttribute(enableDisableEditBox,"disabled"),null);

	}
}
