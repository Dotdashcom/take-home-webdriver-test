package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.JavaScriptAlertsPage;
public class JavascriptAlertHelper extends Helper {
	JavaScriptAlertsPage javaScriptAlertsPage;
	public JavascriptAlertHelper (Config testConfig) {
		super(testConfig);
		openJavaScriptAlertsPage();
	}
	public void openJavaScriptAlertsPage() {
		String javaScriptAlertsPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("JavaScriptAlertsPage");
		Browser.openPageUrl(testConfig, javaScriptAlertsPageUrl);
		javaScriptAlertsPage = new JavaScriptAlertsPage(testConfig);
	}
	public void verifyResultMessage(String expectedMessage) {
		Logger.AssertEqualAndLog("Verifying result message - " + expectedMessage, javaScriptAlertsPage.getResultMessage(), expectedMessage);
	}
	public void clickJsAlert() {
		javaScriptAlertsPage.clickJsAlert();
	}
	public void verifyAlertMessage(String expectedAlertMessage) {
		Logger.AssertEqualAndLog("Verifying text on alert - " + expectedAlertMessage, javaScriptAlertsPage.getAlertMessage(), expectedAlertMessage);
	}
	public void acceptAlert() {
		javaScriptAlertsPage.acceptAlert();
	}
	public void cancelAlert() {
		javaScriptAlertsPage.cancelAlert();
	}
	public void confirmAlert(String buttonText) {
		switch (buttonText) {
			case "Ok" :
			case "OK" :
				acceptAlert();
				break;
			case "Cancel" :
				cancelAlert();
				break;
		}
	}
	public void clickJsConfirm() {
		javaScriptAlertsPage.clickJsConfirm();
	}
	public void clickJsPrompt() {
		javaScriptAlertsPage.clickJsPrompt();
	}
	public void enterText(String textToEnter) {
		javaScriptAlertsPage.enterText(textToEnter);
	}
}
