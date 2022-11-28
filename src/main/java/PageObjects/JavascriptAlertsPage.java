package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class JavascriptAlertsPage extends BrowserUtilities {
	public Alert alert;
	public JavascriptAlertsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Click for JS Alert')]")
	WebElement btn_clickJSAlert;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Click for JS Confirm')]")
	WebElement btn_JSAlertConfirm;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Click for JS Prompt')]")
	WebElement btn_clickJSPrompt;
	
	@FindBy(how = How.ID, using = "result")
	WebElement result;

	public void getUrl() {
		driver.get(BaseTest.getURL("javascript_alerts"));
	}
	public void clickAlert() {
		fnClickWebElement(btn_clickJSAlert);	
	}
	public void confirmAlert() {
		fnClickWebElement(btn_JSAlertConfirm);	
	}
	public void clickPrompt() {
		fnClickWebElement(btn_clickJSPrompt);	
	}
	public String getPromptMessage() {
		return getText(result);	
	}
}
