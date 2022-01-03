import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.JavaScriptAlertsPage;

public class Test15JavaScriptAlerts extends TestBase{
    JavaScriptAlertsPage jsAlertPage;

    @Test
    public void test15JavaScriptAlerts() throws InterruptedException{
        jsAlertPage = new JavaScriptAlertsPage(webDriver);
        jsAlertPage.clickJSAlertButton();
        Assert.assertEquals(jsAlertPage.getAlertText(), "I am a JS Alert");
        jsAlertPage.closeAlert();
        Thread.sleep(1000);
        jsAlertPage.clickJSConfirmButton();
        Assert.assertEquals(jsAlertPage.getAlertText(), "I am a JS Confirm");
        jsAlertPage.closeAlert();
        Thread.sleep(1000);
        jsAlertPage.clickJSPromptButton();
        jsAlertPage.enterOnAlert("new type");
        jsAlertPage.closeAlert();
        Thread.sleep(1000);
        Assert.assertEquals(jsAlertPage.getResult(), "You entered: new type");
        
    }
}