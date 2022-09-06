package pages.Tests;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.NotificationMessage;

public class TC13_Notifications extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	@Test
	public void ValidateFlashMessageMultipleTimes() {
		NotificationMessage.NavigateToNotificationsPage();
		for (int i=0;i<6;i++)
		{
		NotificationMessage.ClickHereButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(i);
		String message = NotificationMessage.GetFlashMessage().trim();
		if(message.contains("Action successful"))
		{
			Assert.assertTrue(message , message.contains("Action successful"));
		}
		else if	(message.contains("Action unsuccessful, please try again")) {
			Assert.assertTrue(message , message.contains("Action unsuccessful, please try again"));
		}
		}
		
	}
		

}
