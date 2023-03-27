package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.NewTabPage;
import com.dotDash.page.NotificationPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class NotificationFeature_Test extends BaseTest{
	NotificationPage notificationPage;
	@Test(description = "Test to Validate Notification Feature")
	void validateNotificationPage() throws InterruptedException, IOException {
		notificationPage=PageinstancesFactory.getInstance(NotificationPage.class);
		notificationPage.navigateToNotificationPage();
		notificationPage.validateNotificationFunctionality();
	}
}