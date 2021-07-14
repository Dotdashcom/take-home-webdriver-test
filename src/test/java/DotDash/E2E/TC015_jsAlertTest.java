package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.TC015_jsAlertObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC015_jsAlertTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC015_jsAlertObject jso = new TC015_jsAlertObject(driver);
		jso.getAlertLink().click();
		
		//verifying alert text present & verifying js confirm button
		for(int i = 1; i<=2 ; i++) {
			jso.getAlertButton(i).click();
			String msg = driver.switchTo().alert().getText();
			AssertJUnit.assertTrue(!msg.isEmpty());
			driver.switchTo().alert().accept();
		}
		
		jso.getAlertButton(3).click();
		String message = "Hello world!";
		driver.switchTo().alert().sendKeys(message);
		driver.switchTo().alert().accept();
		AssertJUnit.assertEquals("You entered: "+message, jso.getResultText().getText());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
