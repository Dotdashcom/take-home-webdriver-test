package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class JavaScriptAlertsPage extends BasePage {
	@FindBy (id = "result")
	WebElement resultMessage;
	@FindBy (css = "#content > div > ul > li:nth-child(1) > button")
	WebElement jsAlert;
	@FindBy (css = "#content > div > ul > li:nth-child(3) > button")
	WebElement jsPrompt;
	@FindBy (css = "#content > div > ul > li:nth-child(2) > button")
	WebElement jsConfirm;
	public JavaScriptAlertsPage (Config testConfig) {
		super(testConfig);
	}
	public String getResultMessage() {
		return resultMessage.getText();
	}
	public void clickJsAlert() {
		jsAlert.click();
		testConfig.driver.switchTo().alert();
	}
	public void clickJsConfirm() {
		jsConfirm.click();
		testConfig.driver.switchTo().alert();
	}
	public void clickJsPrompt() {
		jsPrompt.click();
		testConfig.driver.switchTo().alert();
	}
	public String getAlertMessage() {
		return testConfig.driver.switchTo().alert().getText();
	}
	public void acceptAlert() {
		testConfig.driver.switchTo().alert().accept();
		testConfig.driver.switchTo().defaultContent();
	}
	public void cancelAlert() {
		testConfig.driver.switchTo().alert().dismiss();
	}
	public void enterText(String textToEnter) {
		testConfig.driver.switchTo().alert().sendKeys(textToEnter);
	}
}
