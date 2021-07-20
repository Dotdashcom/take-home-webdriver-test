package com.dotdash.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Evaluator.ContainsText;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.NotificationMessagesPage;


public class NotificationMessagesPageTest extends TestBase {
	
	NotificationMessagesPage notificationMessagesPage;
	
	public NotificationMessagesPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		notificationMessagesPage = new NotificationMessagesPage();	
	}
	
	@Test(priority=1)
	public void checked(){
		List<String> expectedMessagesList = new ArrayList<String>();
		expectedMessagesList.add("Action successful");
		expectedMessagesList.add("Action unsuccesful, please try again");
		expectedMessagesList.add("Action unsuccessful");
		
		String str= notificationMessagesPage.newNotification().trim().toLowerCase();
		boolean expected = false;
		for(String expectedMessage : expectedMessagesList) {
			if(str.contains(expectedMessage.toLowerCase())) {
				expected = true;
				break;
			}
		}
		Assert.assertTrue(expected, String.format("%s is not in the expected message list", str));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
