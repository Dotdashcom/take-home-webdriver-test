package Tests;

import Baseclass.BaseClass;
import Pages.JavascriptPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsJavascript extends BaseClass {

    @Test
    public void T017_Javascript_Alert_Testing() {
        JavascriptPage javascriptPage = new JavascriptPage(driver);
        javascriptPage.GoToJavascriptAlerts();
        javascriptPage.ClickForJSAlert();
        javascriptPage.AssertForJSAlert();
    }
    @Test
    public void T018_Javascript_Confirm_Testing() {
        JavascriptPage javascriptPage = new JavascriptPage(driver);
        javascriptPage.GoToJavascriptAlerts();
        javascriptPage.ClickForJSConfirm();
        javascriptPage.AssertForJSConfirmAccept();
        javascriptPage.ClickForJSConfirm();
        javascriptPage.AssertForJSConfirmCancel();
    }
    @Test
    public void T019_Javascript_Prompt_Testing() {
        JavascriptPage javascriptPage = new JavascriptPage(driver);
        javascriptPage.GoToJavascriptAlerts();
        javascriptPage.ClickForJSPrompt();
        javascriptPage.AssertForJSPrompt();
    }
    @Test
    public void T020_Javascript_Prompt_Testing() {
        JavascriptPage javascriptPage = new JavascriptPage(driver);
        javascriptPage.GoToJavascriptError();
        Assert.assertFalse(javascriptPage.AssertJavascriptError());
    }


}
