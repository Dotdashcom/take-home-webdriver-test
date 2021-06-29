package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.PageLoader;

public class DynamicControls {
	
	private WebDriver driver = null;
	private final int MAX = 60; // max time in seconds to wait for element
		
	@FindBy(how=How.CSS, using="#checkbox-example button")	
	private WebElement toggleCheckboxButton;
	
	@FindBy(how=How.ID, using="checkbox")
	private WebElement checkbox;
	
	@FindBy(how=How.CSS, using="#input-example button")	
	private WebElement toggleInputButton;
	
	@FindBy(how=How.CSS, using="#input-example input")
	private WebElement inputField;
	
	private WebDriverWait wait = null;
		
	public DynamicControls(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, MAX);
	}
	
	public void clickRemoveCheckboxButton() {
				
		wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxButton));
		
		if (toggleCheckboxButton.getText().equals("Remove")) {
			toggleCheckboxButton.click();
		} else {
			System.out.println("Wanted to click Remove, but button is not in that state.");
		}
	}

	public void clickAddCheckboxButton() {
	
		wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxButton));
		
		if (toggleCheckboxButton.getText().equals("Add")) {
			toggleCheckboxButton.click();
		} else {
			System.out.println("Wanted to click Add, but button is not in that state.");
		}
	}
	
	public void clickEnableButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(toggleInputButton));
		
		if (toggleInputButton.getText().equals("Enable")) {
			toggleInputButton.click();
		} else {
			System.out.println("Wanted to click Enable, but button is not in that state.");
		}
	}

	public void clickDisableButton() {
	
		wait.until(ExpectedConditions.elementToBeClickable(toggleInputButton));
		
		if (toggleInputButton.getText().equals("Disable")) {
			toggleInputButton.click();
		} else {
			System.out.println("Wanted to click Disable, but button is not in that state.");
		}
	}
	
	
	
	public String getMessage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		return driver.findElement(By.id("message")).getText();
	}

	/**
	 * Helper to detect if checkbox exists or not
	 * @param exists the condition to check for
	 * @return true if checkbox matches condition
	 */
	public boolean isCheckboxPresent(boolean exists) {
		int size = driver.findElements(By.id("checkbox")).size();
		return exists ? size > 0 : size == 0;
	}
	
	/**
	 * Helper to detect if field is enabled
	 * @param enabled the condition to check for
	 * @return true if enabled state matches condition
	 */
	public boolean isTextFieldEnabled(boolean enabled) {
		boolean isEnabled = inputField.isEnabled();
		return enabled ? isEnabled : !isEnabled;
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/dynamic_controls");		
	}
	
	
}
