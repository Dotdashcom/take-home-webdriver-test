package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;
import utilities.TestHandler;

public class DynamicControlsPage {

	WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(css = "form#checkbox-example > button")
	WebElement removeAddChkButton;

	@FindBy(css = "form#input-example > button")
	WebElement disableEnableButton;

	@FindBy(css = "form#checkbox-example > p#message")
	WebElement checkBoxMessage;

	@FindBy(css = "form#input-example > p#message")
	WebElement inputMessage;

	public void clickRemoveOrAddChkButton() {
		removeAddChkButton.click();
	}

	public void clickDisableOrEnableButton() {
		disableEnableButton.click();
	}

	public String waitAndGetCheckBoxFormMessage() {
		return getMessage(checkBoxMessage);
	}

	public String waitAndGetInputFormMessage() {
		return getMessage(inputMessage);
	}

	private String getMessage(WebElement messageElement) {
		String message = "";
		try {
			TestHandler.waitForElementToBeVisible(messageElement, 15);
			message = messageElement.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return message;
	}

	// get url
	public DynamicControlsPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/dynamic_controls");
		return this;
	}
}
