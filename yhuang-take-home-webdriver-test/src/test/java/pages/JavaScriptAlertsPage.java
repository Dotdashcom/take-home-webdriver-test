package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BaseDriver{
	public JavaScriptAlertsPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(xpath="//button[@onclick='jsAlert()']")
	public WebElement JsAlertBtn;
	
	@FindBy(xpath="//button[@onclick='jsConfirm()']")
	public WebElement JsConfirmBtn;
	
	@FindBy(xpath="//button[@onclick='jsPrompt()']")
	public WebElement JsPromptBtn;
	
	@FindBy(id="result")
	public WebElement resultText;
	
	public String jsAlertClick() {
		JsAlertBtn.click();
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
	}
	
	public String jsConfirmClick() {
		JsConfirmBtn.click();
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
	}
	
	public String jsPromptClick(String typedText) {
		JsPromptBtn.click();
		driver.switchTo().alert().sendKeys(typedText);
		driver.switchTo().alert().accept();
		return resultText.getText();
	}
	
	public String getResultText() {
		return resultText.getText();
	}
}
