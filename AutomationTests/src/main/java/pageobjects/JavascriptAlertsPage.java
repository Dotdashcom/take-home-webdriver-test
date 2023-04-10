package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavascriptAlertsPage {
	public WebDriver driver;

	public JavascriptAlertsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@onclick='jsAlert()']")
	private WebElement jsAlertButton;

	@FindBy(css="button[onclick='jsConfirm()']")
	private WebElement jsConfirmButton;

	@FindBy(xpath="//button[text()='Click for JS Prompt']")
	private WebElement jsPromptButton;

	@FindBy(id="result")
	private WebElement result;

	public String checkJSAlert() {
		jsAlertButton.click();
		driver.switchTo().alert().accept();
		return result.getText();
	}

	public String checkJSConfirm(String action) {
		jsConfirmButton.click();
		if(action.equalsIgnoreCase("accept"))
			driver.switchTo().alert().accept();
		else if(action.equalsIgnoreCase("cancel"))
			driver.switchTo().alert().dismiss();
		return result.getText();

	}

	public String checkJSPrompt(String action,String message) {
		jsPromptButton.click();
		if(action.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().sendKeys(message);
			driver.switchTo().alert().accept();
		}
		else if(action.equalsIgnoreCase("cancel"))
			driver.switchTo().alert().dismiss();
		return result.getText();
	}
}
