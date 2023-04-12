package alert_tests;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.javascript_alerts_page.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTest extends Base {
    @Test
    public void jsAlertTest(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        String expectedMessage="You successfuly clicked an alert";
        javaScriptAlertsPage.clickAlertButton();
        assertEquals(JavaScriptAlertsPage.alertMessage.getText(),expectedMessage);
    }
    @Test
    public void jsConfirmTest(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        String expectedMessage="You clicked: Ok";
        javaScriptAlertsPage.clickForJsConfirmButton();
        assertEquals(JavaScriptAlertsPage.alertMessage.getText(),expectedMessage);
    }
    @Test
    public void jsPromptTest(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        String word ="hello world";
        String expectedMessage="You entered: "+word;
        javaScriptAlertsPage.clickForJsPromptButton(word);
        assertEquals(JavaScriptAlertsPage.alertMessage.getText(),expectedMessage);
    }

}
