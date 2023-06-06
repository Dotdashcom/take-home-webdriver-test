package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class NotificationMsgTest extends BaseTest{
TestPage otherTests ;
	
	@Test
	public void notificationMsg() {
		System.out.println("18. Notification Message");
		otherTests = new TestPage(driver);
		
		otherTests.notificationMsg();
	}
}
