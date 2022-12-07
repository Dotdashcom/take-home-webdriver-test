package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.Config;
public class DynamicLoadingPage extends BasePage {
	@FindBy (css = "#start > button")
	WebElement startButton;
	@FindBy (id = "loading")
	WebElement loadingBar;
	@FindBy (id = "finish")
	WebElement finishMessage;
	public DynamicLoadingPage (Config testConfig) {
		super(testConfig);
	}
	public void clickStartButton() {
		startButton.click();
	}
	public boolean verifyLoadingBar() {
		WebDriverWait webDriverWait = new WebDriverWait(this.testConfig.driver, 5);
		webDriverWait.until(ExpectedConditions.visibilityOf(loadingBar));
		return loadingBar.isDisplayed();
	}
	public String getMessageAfterLoading() {
		WebDriverWait webDriverWait = new WebDriverWait(this.testConfig.driver, 5);
		webDriverWait.until(ExpectedConditions.visibilityOf(finishMessage));
		return finishMessage.getText();
	}
}
