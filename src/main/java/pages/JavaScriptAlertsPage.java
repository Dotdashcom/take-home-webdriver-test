package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaScriptAlertsPage {
	static WebDriver driver;

	public JavaScriptAlertsPage(WebDriver driver) {
		JavaScriptAlertsPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//button[@onclick = 'jsAlert()']")
	WebElement JS_ALERT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@onclick = 'jsConfirm()']")
	WebElement JS_CONFIRM_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@onclick = 'jsPrompt()']")
	WebElement JS_PROMPT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[@id = 'result']")
	WebElement JS_PROMPT_RESULT_ELEMENT;

//	Methods
	public void clickJSAlertButton() {
		JS_ALERT_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatinJSAlertButtonMessage() {
		String actualJSAlertButtonMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualJSAlertButtonMessage, "I am a JS Alert",
				"JS Alert Message did not match the expected!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handlingJSAlertButton() {
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickJSConfirmButton() {
		JS_CONFIRM_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatinJSConfirmButtonMessage() {
		String actualJSConfirmButtonMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualJSConfirmButtonMessage, "I am a JS Confirm",
				"JS Confirm Message did not match the expected!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handlingJSConfirmButton() {
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	Message For JSPromptButton In The Form Of A Global Variable
	String JSPromptButtonMessage = "Oh no, this does not seem good!!";

	public void clickJSPromptButton() {
		JS_PROMPT_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void typingMessageToJSPromptButton() {
		driver.switchTo().alert().sendKeys(JSPromptButtonMessage);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handlingJSPromptButton() {
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validationJSPromptButtonAlertContainedMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(JS_PROMPT_RESULT_ELEMENT));
		Assert.assertEquals(JS_PROMPT_RESULT_ELEMENT.getText(), "You entered: " + JSPromptButtonMessage, "JS Prompt Button Alert did not contain the typed message!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
