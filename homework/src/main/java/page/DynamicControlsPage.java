package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

	WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Dynamic Controls')]")
	WebElement DYNAMIC_CONTROLS_MENU_ELEMENT;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Remove')]")
	WebElement REMOVE_BUTTON;

//	@FindBy(how = How.XPATH, using = "//div[@id='checkbox']")
//	WebElement CHECKBOX;

	@FindBy(how = How.XPATH, using = "//*[@id=\"message\"]")
	WebElement MESSAGE;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add')]")
	WebElement ADD_BUTTON;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Enable')]")
	WebElement ENABLE_BUTTON;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Disable')]")
	WebElement DISABLE_BUTTON;

	@FindBy(how = How.XPATH, using = "//*[@id=\"input-example\"]/input")
	WebElement TEXT_BOX;

	public void dynamicControlsMenu() {

		DYNAMIC_CONTROLS_MENU_ELEMENT.click();

	}

	public void clickAndValidate() {

		REMOVE_BUTTON.click();

		// explicit wait for the add button
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ADD_BUTTON));

		// explicit wait for the message
		wait.until(ExpectedConditions.visibilityOf(MESSAGE));
		// wait.until(ExpectedConditions.visibilityOf(ADD_BUTTON));

		ADD_BUTTON.click();
		wait.until(ExpectedConditions.visibilityOf(REMOVE_BUTTON));

		ENABLE_BUTTON.click();
		wait.until(ExpectedConditions.visibilityOf(MESSAGE));

		boolean eb = TEXT_BOX.isEnabled();
		System.out.println(eb);

		DISABLE_BUTTON.click();
		wait.until(ExpectedConditions.elementToBeClickable(ENABLE_BUTTON));

	}

}
