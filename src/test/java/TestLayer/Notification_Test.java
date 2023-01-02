package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Notification;

public class Notification_Test  extends BaseClass{
	Notification no;
	public Notification_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		no=new Notification();
		
	}
	@Test
	public void tcNotificationMsg() throws InterruptedException {
		Assert.assertTrue(no.NotificationMsg());
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
