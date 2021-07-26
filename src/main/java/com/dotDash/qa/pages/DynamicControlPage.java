package com.dotDash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class DynamicControlPage extends TestBase {

	// Finding the link to the context Menu page
	@FindBy(xpath = "//a[@href='/dynamic_controls']")
	WebElement dynamicControl;

	// Finding the check box
	@FindBy(id = "checkbox")
	WebElement checkbox;

	// Finding check box enable/disable button
	@FindBy(xpath = "//button[@onclick=\"swapCheckbox()\"]")
	WebElement buttonCheckBox;

	// Finding the text box enable/disable button
	@FindBy(xpath = "//button[@onclick=\"swapInput()\"]")
	WebElement buttonTextBox;

	// Finding the message label of CheckBox and TextBox
	@FindBy(id = "message")
	WebElement message;

	// Initializing the Page Objects:
	public DynamicControlPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// CheckBox Disable test function
	public boolean dynamicCheckbox() {
		dynamicControl.click();
		buttonCheckBox.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));
		boolean invisible = driver.findElements(By.id("checkbox")).size() == 0;
		return invisible;
	}

	// CheckBox enable test function
	public boolean dynamicCheckboxEndable() {
		buttonCheckBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's back!"));
		boolean visible = driver.findElements(By.id("checkbox")).size() == 0;
		return visible;
	}

	// TextBox Enable test function
	public boolean dynamicTextbox() {
		dynamicControl.click();
		buttonTextBox.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));
		boolean enabled = driver.findElements(By.cssSelector("input[type='text']")).size() == 0;
		return enabled;
	}

	// TestBox Disable test function
	public boolean dynamicTextboxDisable() {
		buttonTextBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's disabled!"));
		boolean disabled = driver.findElements(By.cssSelector("input[type='text']")).size() != 0;
		return disabled;
	}
}
