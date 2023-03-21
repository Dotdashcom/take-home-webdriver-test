package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.util.PageLinks;

public class NotificationMessagePage extends BasePage{

	public NotificationMessagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Click here']")
	private WebElement clickHereBtn;
	
	
	@FindBy(xpath = "//div[@id='flash-messages']/div")
	private WebElement flashMessage;
	
	public void visitNotificationMessagePage() {
		getDriver().get(PageLinks.NOTIFICATION_MSG_PAGE);
	}
	
	//Need to clarify the requirement
	public 	void verifyNotificationMessage() throws InterruptedException {
		
		String successMsg = "Action successful";
		String unsuccessMsg = "Action unsuccesful, please try again";
		boolean result = false;
		for (int i = 0; i < 10; i++) {
			clickHereBtn.click();
			Thread.sleep(100);
			String flashMsgTxt = flashMessage.getText().replace("×", "").trim();
			if (flashMsgTxt.equals(successMsg)) {
				result = true;
				break;
			}
		}
		assertTrue(result, "Success message never came");
		result = false;
		for (int i = 0; i < 10; i++) {
			clickHereBtn.click();
			Thread.sleep(1000);
			String flashMsgTxt = flashMessage.getText().replace("×", "").trim();
			if (flashMsgTxt.equals(unsuccessMsg)) {
				result = true;
				break;
			}
		}
		assertTrue(result, "Unsuccess message never came");
	}
}
