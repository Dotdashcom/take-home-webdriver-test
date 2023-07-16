package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.JavaScriptAlertsPage;
import testComponents.BaseTest;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void jsAlert(){
        JavaScriptAlertsPage javaScriptAlertsPage=new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.goTo();
        javaScriptAlertsPage.jsAlert();
        Assert.assertEquals(javaScriptAlertsPage.getMessage(),"You successfuly clicked an alert");
        javaScriptAlertsPage.jsConfirm();
        Assert.assertEquals(javaScriptAlertsPage.getMessage(),"You clicked: Ok");
        javaScriptAlertsPage.jsPrompt();
        Assert.assertEquals(javaScriptAlertsPage.getMessage(),"You entered: message");

    }
}
