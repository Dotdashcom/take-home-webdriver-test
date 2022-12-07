package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.Config;
public class DynamicControlsPage extends BasePage {
	@FindBy (css = "#checkbox > input[type=checkbox]")
	WebElement checkBox;
	@FindBy (css = "#checkbox-example > button")
	WebElement checkBoxButton;
	@FindBy (id = "loading")
	WebElement loading;
	@FindBy (id = "message")
	WebElement message;
	@FindBy (css = "#input-example > input[type=text]")
	WebElement textBox;
	@FindBy (css = "#input-example > button")
	WebElement textBoxButton;
	public DynamicControlsPage (Config testConfig) {
		super(testConfig);
	}
	public void clickCheckBoxButton() {
		checkBoxButton.click();
	}
	public void waitForMessage() {
		WebDriverWait webDriverWait = new WebDriverWait(this.testConfig.driver, 5);
		webDriverWait.until(ExpectedConditions.visibilityOf(message));
	}
	public void clickTextBoxButton() {
		textBoxButton.click();
	}
	public boolean isLoadingDisplayed() {
		return loading.isDisplayed();
	}
	public String getSuccessMessage() {
		return message.getText();
	}
	public boolean isCheckBoxVisible() {
		return checkBox.isDisplayed();
	}
	public boolean isTextBoxEnabled() {
		return textBox.isEnabled();
	}
	public String checkBoxButtonText() {
		return checkBoxButton.getText();
	}
	public String textBoxButtonText() {
		return textBoxButton.getText();
	}
}
