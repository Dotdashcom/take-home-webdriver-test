package com.TakeHomeTest.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.NotificationMessagePageObjects;

public class NotificationMessageTest extends BaseClass{
	String notifiedmessage;

	@Test(enabled=true)
	public void successnotificationmsg() {
		NotificationMessagePageObjects notifypage=new NotificationMessagePageObjects(driver);

		driver.get(url+"/notification_message_rendered");
		boolean flag=false;

		for(int i=0;i<=10;i++) {
			notifypage.ClickHere();
			notifiedmessage=notifypage.messageDisplayed();

			if(notifiedmessage.contains("Action successful"))
			{
				flag=true;
				Assert.assertTrue(flag);
		}		
			break;
		}		
	}
	
	@Test(enabled=true)
	public void unsuccessnotificationmsg() {
		NotificationMessagePageObjects notifypage=new NotificationMessagePageObjects(driver);

		driver.get("http://localhost:7080/notification_message_rendered");
		boolean flag=false;

		for(int i=0;i<=10;i++) {
			notifypage.ClickHere();
			notifiedmessage=notifypage.messageDisplayed();

			if(notifiedmessage.contains("Action unsuccessful, please try again"))
			{
				flag=true;
				Assert.assertTrue(flag);
		}
			break;
		}
		
	}
}
