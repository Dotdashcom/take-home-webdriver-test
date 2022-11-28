package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.JavascriptAlertsPage;
import TestBase.BaseTest;

public class JavaScriptAlertsPageTest extends BaseTest {
	JavascriptAlertsPage jsAlert;

	public JavaScriptAlertsPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		jsAlert = new JavascriptAlertsPage();
	}

	@Test
	public void clickJSAlert() {

		// logging into application
		jsAlert.getUrl();

		// Click alert button
		jsAlert.clickAlert();

		// Alert Message (Expected Text)
		String expectedAlertMessage = "I am a JS Alert";

		// Captured Alert Text (Actual Text)
		String actualAlertMessage = driver.switchTo().alert().getText();

		// Assertion
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		// Accept the alert (Click OK)
		driver.switchTo().alert().accept();
	}

	@Test
	public void confirmJSAlert() {

		// logging into application
		jsAlert.getUrl();

		// Click alert button
		jsAlert.confirmAlert();

		// Alert Message (Expected Text)
		String expectedAlertMessage = "I am a JS Confirm";

		// Captured Alert Text (Actual Text)
		String actualAlertMessage = driver.switchTo().alert().getText();

		// Assertion
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		// Accept the alert (Click OK)
		driver.switchTo().alert().accept();
	}

	@Test
	public void clickJSPrompt() {

		// logging into application
		jsAlert.getUrl();

		// Click alert button
		jsAlert.clickPrompt();

		// Send Message to Alert box
		//String expectedAlertMessage = "I am a JS prompt";

		// Captured Alert Text (Actual Text)
		driver.switchTo().alert().sendKeys("Hello Everyone!");

		// Accept the alert (Click OK)
		driver.switchTo().alert().accept();

		Assert.assertEquals("You entered: Hello Everyone!", jsAlert.getPromptMessage());
	}

}
