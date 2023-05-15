package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest{
	@Test(priority=1)
	public void JsAlerts() {
		HomePage homePage = new HomePage(driver);
		JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
		String alertText = jsAlert.clickJsAlert();
		assertEquals(alertText, "I am a JS Alert");
	}
	@Test(priority=2)
	public void confirmAlerts() {
		HomePage homePage = new HomePage(driver);
		JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
		String alertText = jsAlert.clickConfirm();
		assertEquals(alertText, "I am a JS Confirm");
	}
	
	@Test(priority=3)
	public void promptAlerts() {
		HomePage homePage = new HomePage(driver);
		JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
		String message = "test";
		jsAlert.clickPrompt(message);
		assertTrue(jsAlert.getResult().contains(message));
	}

}
