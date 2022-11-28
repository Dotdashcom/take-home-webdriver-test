package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class NotificationMessagePage extends BrowserUtilities {
	public NotificationMessagePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click here')]")
	WebElement btn_Click;
	
	@FindBy(how = How.ID, using = "flash")
	WebElement notificationMessage;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("notification_message_rendered"));
	}
	public void clickHere() {
		Click(btn_Click);
	}
	public String getNotificationMessageText() {
		return getText(notificationMessage);
	}
	public void explicitWaitOfElement() {
		fnExplictWaitOfElement(driver,notificationMessage);
	}
}
