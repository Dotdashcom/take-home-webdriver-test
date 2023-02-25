package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.NotificationMessagePage;

public class Tc018_NotificationMessageTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/notification_message_rendered");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void NotificationMessageTest() throws IOException {
		NotificationMessagePage nmp = new NotificationMessagePage(driver);
		nmp.HandlingNotificationMessage();
		bu.captureSrceenshot(driver, "NotificationMessageTest");
		
	}

}
