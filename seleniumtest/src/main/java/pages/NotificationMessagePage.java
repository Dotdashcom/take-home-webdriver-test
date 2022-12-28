package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class NotificationMessagePage extends GenericPage {

	@FindBy(linkText = "Click here")
	private WebElement clickLink;

	@FindBy(xpath = "//div[@class='flash notice']")
	private WebElement message;

	public NotificationMessagePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getNotificationMsgBool() throws InterruptedException {
		clickLink.click();
		Thread.sleep(2000);
		
		String text = message.getText();
		if("Action successful\n×".equals(text) || "Action unsuccesful, please try again\n×".equals(text) ) {
			return true;
		}
		return false;
	}
}