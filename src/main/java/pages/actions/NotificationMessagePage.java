package pages.actions;

import org.testng.Assert;

import base.Page;

public class NotificationMessagePage extends Page{
	
	public void verifyNotificationMessage() {
		click(locators.notificationClick);
		click(locators.notificationClick);
		click(locators.notificationClick);
		click(locators.notificationClick);
		System.out.println(locators.notificationMessage.getText());
		Assert.assertTrue((locators.notificationMessage.getText().contains("Action unsuccesful") ||locators.notificationMessage.getText().contains("Action succesful")) );
		
	}

}
