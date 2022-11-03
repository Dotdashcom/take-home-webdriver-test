package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.JavascriptAlertPage;

public class TestSuite_JavascriptAlerts extends BaseTestClass {

    JavascriptAlertPage javascriptAlertPage = JavascriptAlertPage.getInstance();

    @BeforeClass
    public void beforeClass() {
        ActionHelper.openUrl(Constants.JAVASCRIPT_ALERT_PAGE_URL);
    }


    @Test
    public void TC_JavascriptAlerts_001_Verify_AlertMessage() {
        javascriptAlertPage.clickJSAlert();
        Assert.assertEquals(javascriptAlertPage.getJSAlertMessage(), "I am a JS Alert");
        javascriptAlertPage.alertAccept();
        Assert.assertEquals(javascriptAlertPage.getTextResultMessageLabel(), "You successfuly clicked an alert");

    }

    @Test
    public void TC_JavascriptAlerts_002_Verify_ConfirmAlertMessage() {
        javascriptAlertPage.clickJSConfirm();
        Assert.assertEquals(javascriptAlertPage.getJSAlertMessage(), "I am a JS Confirm");
        javascriptAlertPage.alertAccept();
        Assert.assertEquals(javascriptAlertPage.getTextResultMessageLabel(), "You clicked: Ok");
    }

    @Test
    public void TC_JavascriptAlerts_003_Verify_FillPromptAlertMessage() {
        String text = "Happy";
        javascriptAlertPage.clickJSPrompt();
        javascriptAlertPage.fillJsPrompt(text);
        javascriptAlertPage.alertAccept();
        Assert.assertEquals(javascriptAlertPage.getTextResultMessageLabel(), "You entered: " + text);
    }
}
