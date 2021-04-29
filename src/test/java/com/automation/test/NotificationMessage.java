package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.NewTabPage;
import com.automation.pageobject.NotificationMessagePage;

public class NotificationMessage extends BaseTest {

	@Test
	public void NotificationMessageTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/notification_message_rendered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		NotificationMessagePage.validateNotificationMessageHeader(driver);
		NotificationMessagePage.validateClickMessage(driver);
		
		
		
	}
}
