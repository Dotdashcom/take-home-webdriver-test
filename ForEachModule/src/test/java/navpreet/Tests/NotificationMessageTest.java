package navpreet.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import navpreet.pageobjects.NotificationMessagePageObjects;
import navpreet.util.ObjectsOfClasses;

public class NotificationMessageTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	NotificationMessagePageObjects nmpo;
	String actual,message;

	
	
	@Test(description="Test clicks on the Click Here link a multiple times.Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.")
	public void testNotificationMessage() throws IOException
	{
		nmpo=notificationMessagesApplication();
		nmpo.clickNotificationMessages();

		for (int i = 0; i <= 5; i++) {
			nmpo.clickClickHere();
			 nmpo.Notifications();
		}
		
	}
}
