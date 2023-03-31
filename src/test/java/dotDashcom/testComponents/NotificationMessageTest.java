package dotDashcom.testComponents;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dotDashcom.pageObjects.NotificationMessagePage;

public class NotificationMessageTest extends BaseTest {

	NotificationMessagePage notificationMessage;

	@Before
	public void setup() throws IOException {

		setup("/notification_message_rendered");
		notificationMessage = new NotificationMessagePage(driver);
	}

	@Test
	public void checkNotification() {
		String message;
		for (int i = 0; i <= 5; i++) {
			notificationMessage.clickOnLink();
			message = notificationMessage.checkNotificationMessage();
			Assert.assertThat(message.trim(),
					anyOf(is("Action successful"), is("Action unsuccesful, please try again")));
		}
	}

}
