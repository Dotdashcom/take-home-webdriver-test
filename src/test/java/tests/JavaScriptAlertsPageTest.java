package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "javascriptAlertUrl", "jsAlertMessage", "jsConfirmMessage", "typeJsPromptMessage", "jsPromptMessage"})
    public void javaScript_Alerts_Test(String baseUrl, String javascriptAlertUrl, String jsAlertMessage, String jsConfirmMessage, String typeJsPromptMessage, String jsPromptMessage) {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.goToUrl(baseUrl , javascriptAlertUrl);

        javaScriptAlertsPage.clickJsAlertButton();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(jsAlertMessage));

        javaScriptAlertsPage.clickJsConfirmButton();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(jsConfirmMessage));

        javaScriptAlertsPage.clickJsPromptButton();
        javaScriptAlertsPage.typeMessageOnPrompt(typeJsPromptMessage);
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(jsPromptMessage));
    }
}
