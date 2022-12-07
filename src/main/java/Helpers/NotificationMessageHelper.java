package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.NotificationMessagePage;
public class NotificationMessageHelper extends Helper {
	NotificationMessagePage notificationMessagePage;
	public NotificationMessageHelper (Config testConfig) {
		super(testConfig);
		openNotificationMessagePage();
	}
	public void openNotificationMessagePage() {
		String notificationMessagePageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("NotificationMessagePage");
		Browser.openPageUrl(testConfig, notificationMessagePageUrl);
		notificationMessagePage = new NotificationMessagePage(testConfig);
	}
	public void clickForNotification() {
		notificationMessagePage.clickForNotification();
	}
	public void verifyNotificationMessage() {
		Logger.AssertContainsAndLog("Verifying notification message on click", notificationMessagePage.getNotificationMessage(), "Action");
	}
}
