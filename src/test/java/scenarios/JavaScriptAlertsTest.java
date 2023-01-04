package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest {
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod
    public void setup() {
        javaScriptAlertsPage = homePage.gotoJavaScriptAlertsPage();
    }

    @Test
    public void verifyJSAlertMessage() {
        String jsAlertMessageText = javaScriptAlertsPage.clickJSAlertButton()
                .getJSAlertMessageText();
        Assert.assertEquals(jsAlertMessageText, "I am a JS Alert", "JS alert message doesn't match!");
    }

    @Test
    public void verifyJSConfirmMessage() {
        String jsAlertMessageText = javaScriptAlertsPage.clickJSConfirmButton()
                .getJSAlertMessageText();
        Assert.assertEquals(jsAlertMessageText, "I am a JS Confirm", "JS confirm message doesn't match!");
    }

    @Test
    public void verifyJSPromptTypedMessage() {
        String typedMessage = "QA Automation";
        boolean isResultTextContainsTypedMessage = javaScriptAlertsPage.clickJSPromptButton()
                .enterPromptMessage(typedMessage)
                .acceptAlert()
                .getResultText("You entered: " + typedMessage);
        Assert.assertTrue(isResultTextContainsTypedMessage, "Result text doesn't contain JS Prompt typed message!");
    }
}