package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;


import com.base.Base;
import com.pages.NotificationMessagePage;

public class NotificationMessageTest extends Base{
	
	NotificationMessagePage nmp;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Notification Messages")).click();
		nmp=new NotificationMessagePage();
	}
	
	@Test
	public void validateTheActionSuccessfullMsgIsDisplayed() throws InterruptedException {
		nmp.clickOnClickBtnUntilDesiredNotificationMsgIsDisplayed(nmp.expectedSuccessMessage());
		Assert.assertEquals(nmp.getNotificationMessage(),nmp.expectedSuccessMessage());


	}
	
	@Test
	public void validateTheActionUnsuccessfullMsgIsDisplayed() throws InterruptedException {
		nmp.clickOnClickBtnUntilDesiredNotificationMsgIsDisplayed(nmp.expectedUnsuccessMessage());
		Assert.assertEquals(nmp.getNotificationMessage(),nmp.expectedUnsuccessMessage());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
