package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.NotificationPage;


public class NotificationPageTestCase extends BaseClass {
	public NotificationPage notificationPage;
	public NotificationPageTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlNotificationMessage");
		notificationPage = new NotificationPage();	
	}
	
	@Test
	public void validateNotification() {
		Assert.assertTrue(notificationPage.validatetext());
	}
	
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
