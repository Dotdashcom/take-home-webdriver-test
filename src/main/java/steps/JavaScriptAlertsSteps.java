package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsSteps {

    JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Step("Check JS Alert")
    public void checkJsAlert(String alertText, String resultText){
        javaScriptAlertsPage.clickForJsAlert();
        Assert.assertEquals(javaScriptAlertsPage.getTextForJsAlert(), alertText);
        javaScriptAlertsPage.closeJsAlert();
        Assert.assertEquals(javaScriptAlertsPage.getTextResult(), resultText);
    }

    @Step("Check JS Confirm")
    public void checkJsConfirm(String resultText) {
        javaScriptAlertsPage.clickForJsConfirm();
        javaScriptAlertsPage.acceptJsAlert();
        Assert.assertEquals(javaScriptAlertsPage.getTextResult(), resultText);
    }

    @Step("Check JS Prompt")
    public void checkJsPrompt(String text, String resultText){
        javaScriptAlertsPage.clickForJsPrompt();
        javaScriptAlertsPage.sendTextForJsPrompt(text);
        javaScriptAlertsPage.acceptJsAlert();
        Assert.assertEquals(javaScriptAlertsPage.getTextResult(), resultText);
    }

}
