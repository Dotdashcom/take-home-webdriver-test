package RamanpreetSinghtest.SeleniumTest;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.NotificationMessagePage;
import TestComponents.BaseTest;

public class NotificationTest extends BaseTest {

	@Test
	public void notificationMessage() throws InterruptedException {
		NotificationMessagePage notificationPage = landingpage.getnotificationPage();
		String[] allmsgs = { "Action Successful".trim().toLowerCase(), "Action unsuccesful, please try again".trim().toLowerCase(), 
				"Action Unsuccessful".trim().toLowerCase() };
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(allmsgs));
		String actualmsg = notificationPage.notificationMessage();
		Assert.assertTrue(arrayList.contains(actualmsg.trim().toLowerCase()));

	}

}
