package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.NotificationMessageHelper;
public class TestNotificationMessage extends TestBase {
	@TestData ({"1", "2", "3", "4", "5"})
	@Test (description = "Test notification message", dataProvider = "GetTestData")
	public void testNotificationMessage(Config testConfig, String numberOfClicks) {
		NotificationMessageHelper notificationMessageHelper = new NotificationMessageHelper(testConfig);
		for (int i = 0; i <= Integer.valueOf(numberOfClicks); i++) {
			notificationMessageHelper.clickForNotification();
			notificationMessageHelper.verifyNotificationMessage();
		}
	}
}
