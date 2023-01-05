package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.NewWindowPages;
import java.Pages.NotificationMessage;
import basePack.BaseClass;

public class NotificationMessageTestcase extends BaseClass{

	public NotificationMessageTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	NotificationMessage notification;
	@BeforeMethod
	@Parameters("notification")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		notification=new NotificationMessage(driver);
		
	}
	
	@Test
	public void notificationMessageFunctionality()
	{
		
		notification.clickForNotification();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
