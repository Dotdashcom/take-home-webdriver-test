package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.jsAlertsPage;
import pageObjects.newWindowPage;
import pageObjects.notificationMessagePage;
import utils.Baseclass;

public class NotificationTest {

	Baseclass bs;
	notificationMessagePage nmp;
	@BeforeClass
	public void prereqsteps()
	{
		bs = new Baseclass();
		bs.generateExecutionId();
		bs.createResultsLocation();
	}
	
	@BeforeMethod
	public void launchAPP() 
	{
		bs.launchApplication("/notification_message_rendered");
		nmp = new notificationMessagePage(bs);
	}

	/*
	 * Verify verify Notification Message
	 */
	@Test
	public void verifyNotificationMessage() 
	{
		nmp.clickOnClickHere();
		Assert.assertEquals(nmp.actualMessages().contains(nmp.getmessage()),true);
		nmp.clickOnClickHere();
		Assert.assertEquals(nmp.actualMessages().contains(nmp.getmessage()),true);
		nmp.clickOnClickHere();
		Assert.assertEquals(nmp.actualMessages().contains(nmp.getmessage()),true);
		nmp.clickOnClickHere();
		Assert.assertEquals(nmp.actualMessages().contains(nmp.getmessage()),true);
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
