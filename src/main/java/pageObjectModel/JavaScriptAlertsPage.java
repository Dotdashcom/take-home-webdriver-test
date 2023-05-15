package pageObjectModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {
	private WebDriver driver;

	public JavaScriptAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Alert']")
	private WebElement jsAlertButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Confirm']")
	private WebElement confirmButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Prompt']")
	private WebElement promptButton;

	@FindBy(how = How.ID, using = "result")
	private WebElement result;

	public String clickJsAlert() {
		jsAlertButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String clickConfirm() {
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public void clickPrompt(String message) {
		promptButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(message);
		alert.accept();
	}

	public String getResult() {
		return result.getText();
	}
}
