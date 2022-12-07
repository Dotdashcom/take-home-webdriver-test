package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class NotificationMessagePage extends BasePage {
	@FindBy (css = "#content > div > p > a")
	WebElement clickHereText;
	@FindBy (css = "#flash")
	WebElement notificationMessage;
	public NotificationMessagePage (Config testConfig) {
		super(testConfig);
	}
	public void clickForNotification() {
		clickHereText.click();
	}
	public String getNotificationMessage() {
		return notificationMessage.getText();
	}
}
