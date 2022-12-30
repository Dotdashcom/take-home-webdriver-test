package com.takehome.testcases;




import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.NotificationMessage;

public class NotificationMessageTest {
	DriverScript driverSetup;
	NotificationMessage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}

	@Test
	public void notificationmessage() throws InterruptedException {
		page = new NotificationMessage(driverSetup.getDriver(), driverSetup.getBaseURL());
		int noofclicks = 10;

		for (int i = 0; i < noofclicks; i++) {
			page.getClickHereLink().click();
			String alertText = page.getAlertElement().getText();

			Assert.assertTrue(alertText.contains("Action successful")
					|| alertText.contains("Action unsuccesful, please try again")
					|| alertText.contains("Action Unsuccessful"));
			// System.out.println("Success : " +alertText);

			Thread.sleep(1000);
		}

	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}

}
