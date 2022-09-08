package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import util.BrowserFactory;

public class JavaScriptAlertsTest extends BrowserFactory {
	static JavaScriptAlertsPage javaScriptAlertsPage;

	@BeforeMethod
	public static void beforeTests() {
		init("javascript_alerts");
		javaScriptAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);
	}

	@Test(priority = 1)
	public static void testClicksOnJSAlertButton() {
		javaScriptAlertsPage.clickJSAlertButton();
		javaScriptAlertsPage.validatinJSAlertButtonMessage();
		javaScriptAlertsPage.handlingJSAlertButton();
	}

	@Test(priority = 2)
	public static void testClicksOnJSConfirmButtonAndClicksOKOnAlert() {
		javaScriptAlertsPage.clickJSConfirmButton();
		javaScriptAlertsPage.validatinJSConfirmButtonMessage();
		javaScriptAlertsPage.handlingJSConfirmButton();
	}

	@Test(priority = 3)
	public static void testClicksOnJSPromptButtonAndTypesAMessageOnPrompt() {
		javaScriptAlertsPage.clickJSPromptButton();
		javaScriptAlertsPage.typingMessageToJSPromptButton();
		javaScriptAlertsPage.handlingJSPromptButton();
		javaScriptAlertsPage.validationJSPromptButtonAlertContainedMessage();
		
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
