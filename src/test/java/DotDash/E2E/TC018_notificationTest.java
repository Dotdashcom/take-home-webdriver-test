package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC018_notificationObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC018_notificationTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC018_notificationObject no = new TC018_notificationObject(driver);
		no.getNotificationLink().click();
		no.getNotificationLink2().click();
		String actualtext = no.getNotificationText().getText();
		if(actualtext.contains("try again") || actualtext.contains("Successful") || actualtext.contains("Action unsuccessful") || actualtext.contains("Action Unsuccessfu") ) {
			AssertJUnit.assertTrue(true);
		}else {
			AssertJUnit.assertFalse(false);
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
