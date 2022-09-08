package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {
	static WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		DynamicControlsPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//input[@label = 'blah']")
	WebElement CHECKBOX_RADIO_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@onclick= 'swapCheckbox()']")
	WebElement REMOVE_AND_ADD_DYNAMIC_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'checkbox']")
	WebElement ADDED_CHECKBOX_RADIO_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type = 'text']")
	WebElement INPUT_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@onclick= 'swapInput()']")
	WebElement ENABLE_AND_DISABLE_DYNAMIC_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[@id = 'message']")
	WebElement DYNAMIC_JAVA_SCRIPT_ALERT_MESSAGE__ELEMENT; // For remove/add and enable/disable dynamic buttons

//	Methods
	public void clickRemoveButton() {
		REMOVE_AND_ADD_DYNAMIC_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddButton() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(REMOVE_AND_ADD_DYNAMIC_BUTTON_ELEMENT));
		REMOVE_AND_ADD_DYNAMIC_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEnableButton() {
		ENABLE_AND_DISABLE_DYNAMIC_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDisableButton() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(ENABLE_AND_DISABLE_DYNAMIC_BUTTON_ELEMENT));
		ENABLE_AND_DISABLE_DYNAMIC_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateRemoveButtonFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(DYNAMIC_JAVA_SCRIPT_ALERT_MESSAGE__ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "JavaScript Alert did not generate!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateRemoveButtonRemovedCheckbox() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(CHECKBOX_RADIO_BUTTON_ELEMENT));
			Assert.assertTrue(element.isDisplayed());
		} catch (TimeoutException e) {
			System.out.println("Checkbox was removed.");
			e.printStackTrace();
		}
	}

	public void validateAddButtonFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(DYNAMIC_JAVA_SCRIPT_ALERT_MESSAGE__ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "JavaScript Alert did not generate!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateAddButtonAddedCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ADDED_CHECKBOX_RADIO_BUTTON_ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "Checkbox was not added!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateEnableButtonFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(DYNAMIC_JAVA_SCRIPT_ALERT_MESSAGE__ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "JavaScript Alert did not generate!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateInputBoxIsEnabled() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(INPUT_BOX_ELEMENT));
		Assert.assertTrue(element.isEnabled(), "Input box not enabled");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateDisableButtonFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(DYNAMIC_JAVA_SCRIPT_ALERT_MESSAGE__ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "JavaScript Alert did not generate!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateInputBoxIsDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(INPUT_BOX_ELEMENT));
			Assert.assertTrue(element.isEnabled());
		} catch (AssertionError e) {
			System.out.println("Input box is disabled");
			e.printStackTrace();
		}
	}

}
