package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.JSAlertsPage;


public class JSAlertsTest extends BaseTest{
	JSAlertsPage alerts;
	
	@Before
	public void setup() throws IOException {

		setup("/javascript_alerts");
		alerts = new JSAlertsPage(driver);
	}
	
	@Test
	public void checkAllJSAlert() {
		
		String message;
		
		message=alerts.checkJSAlert();
		Assert.assertEquals(message, "You successfuly clicked an alert");
		
		message=alerts.checkJSConfirm("accept");
		Assert.assertEquals(message,"You clicked: Ok");
		message=alerts.checkJSConfirm("cancel");
		Assert.assertEquals(message,"You clicked: Cancel");
		
		message=alerts.checkJSPrompt("accept", "123");
		Assert.assertEquals(message,"You entered: 123");
		message=alerts.checkJSPrompt("cancel", "");
		Assert.assertEquals(message,"You entered: null");
	}

}
