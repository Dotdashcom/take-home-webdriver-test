package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.NotificationMessagePage;

public class NotificationMessageTest extends BaseTest{
	@Test
	public void notificationMsg() {
		HomePage homePage = new HomePage(driver);
		NotificationMessagePage notificationMessage = homePage.clickNotification();
		assertTrue(notificationMessage.clickButtonMultiple());		
	}
}
