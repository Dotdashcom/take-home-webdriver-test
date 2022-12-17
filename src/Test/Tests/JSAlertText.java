package Tests;

import Pages.BasePage;
import Pages.JavaScriptAlertsPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JSAlertText extends BasePage {
    JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/javascript_alerts");
    }

    @Test
    public void TCVerificationJSAlerts(){
        javaScriptAlertsPage.setJsAlertBox();
        Assert.assertEquals(javaScriptAlertsPage.VerificationMessage(),"You successfuly clicked an alert");
        javaScriptAlertsPage.setJsConfirmButtonBox();
        Assert.assertEquals(javaScriptAlertsPage.VerificationMessage(),"You clicked: Ok");
        String text = "Salut";
        javaScriptAlertsPage.setJsPromptButton(text);
        Assert.assertEquals(javaScriptAlertsPage.VerificationMessage(),"You entered: "+text);
    }
}
