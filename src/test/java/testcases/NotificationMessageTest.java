package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class NotificationMessageTest extends TestBase{
	BrowseData data;
	BaseUrl urlvalues;
	public NotificationMessageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test
	public void verifyNotificationError() throws InterruptedException
	{
		driver.get(urlvalues.url_notificationEror);
		int i=3;
		while(i>0)
		{
		data.notificationlink.click();
		Thread.sleep(2000);
		i--;
		}
		String text = data.divmsg.getText();
		
		//test the result based on each of 3 expected result 
		Assert.assertTrue(text.contains("successful") || text.contains("unsuccesful") ||text.contains("please try again"));	
		System.out.println("Assertion pass...");	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
