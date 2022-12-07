package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.JavascriptAlertHelper;
public class TestJavascriptAlert extends TestBase {
	@Test (description = "Test javascript alert", dataProvider = "GetTestConfig")
	public void testJavascriptAlert(Config testConfig) {
		JavascriptAlertHelper javascriptAlertHelper = new JavascriptAlertHelper(testConfig);
		javascriptAlertHelper.clickJsAlert();
		javascriptAlertHelper.verifyAlertMessage("I am a JS Alert");
		javascriptAlertHelper.acceptAlert();
		javascriptAlertHelper.verifyResultMessage("You successfuly clicked an alert");
	}
	@TestData ({"Ok", "Cancel"})
	@Test (description = "Test javascript confirm", dataProvider = "GetTestData")
	public void testJavascriptConfirm(Config testConfig, String buttonText) {
		JavascriptAlertHelper javascriptAlertHelper = new JavascriptAlertHelper(testConfig);
		javascriptAlertHelper.clickJsConfirm();
		javascriptAlertHelper.verifyAlertMessage("I am a JS Confirm");
		javascriptAlertHelper.confirmAlert(buttonText);
		javascriptAlertHelper.verifyResultMessage("You clicked: " + buttonText);
	}
	@TestData ({"=OK", "=Cancel", "abcdefghijklmnopqrstuvwxyz=OK", "ABCDEFGHIJKLMNOPQRSTUVWXYZ=OK", "1234567890=Cancel", "abcdefghijklmnopqrstuvwxyz=Cancel", "ABCDEFGHIJKLMNOPQRSTUVWXYZ=Cancel", "1234567890=OK"})
	@Test (description = "Test javascript prompt", dataProvider = "GetTestData")
	public void testJavascriptPrompt(Config testConfig, String textToEnterAndButton) {
		String button = textToEnterAndButton.split("=")[1];
		String textToEnter = textToEnterAndButton.split("=")[0];
		JavascriptAlertHelper javascriptAlertHelper = new JavascriptAlertHelper(testConfig);
		javascriptAlertHelper.clickJsPrompt();
		javascriptAlertHelper.verifyAlertMessage("I am a JS prompt");
		javascriptAlertHelper.enterText(textToEnter);
		javascriptAlertHelper.confirmAlert(button);
		textToEnter = button.equalsIgnoreCase("Cancel") ? "null" : textToEnter;
		javascriptAlertHelper.verifyResultMessage("You entered: " + textToEnter);
	}
}
