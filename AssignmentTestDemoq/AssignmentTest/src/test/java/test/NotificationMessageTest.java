package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.NotificationMessagePage;

public class NotificationMessageTest extends TestBaseAssignment {

	@Test
	@Parameters({"NotificationMessageUrl"})
	public void NotificationMessageTestCase(String NotificationMessageUrl) throws InterruptedException{
		this.helper.getDriver().get(NotificationMessageUrl);
		this.helper.maximizeWindows();

		NotificationMessagePage dl = new NotificationMessagePage(this.helper.getDriver(), helper);

		Thread.sleep(1000);	
		dl.DoubleClickOnALink();
		Thread.sleep(1000);		
		dl.VerifyNotificationMessage("Action unsuccesful, please try again");		

		dl.DoubleClickOnALink();
		Thread.sleep(1000);		
		dl.VerifyNotificationMessage("Action successful");

	}


}
