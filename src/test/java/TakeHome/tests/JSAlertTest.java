package TakeHome.tests;

import TakeHome.pages.JSAlertPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertTest extends TestBase {
    JSAlertPage page;

    @Test(groups = "JSAlert")
    public void TestAlert(){
        page= new JSAlertPage();
        BrowserUtils.waitFor(3);
        page.clickJsAlertButton();
        Assert.assertTrue(page.alertConfirmationDisplayed(), "JS alert was not displayed but it should");
        Assert.assertEquals(page.getAlertText(), "I am a JS Alert", "Displayed alert message is not what it should be");
    }

    @Test(groups = "JSAlert")
    public void AcceptAlert(){
        page=new JSAlertPage();
        BrowserUtils.waitFor(3);
        page.acceptAlert();
        Assert.assertFalse(page.alertConfirmationDisplayed(), "JS alert was not displayed but it should");
    }

    @Test(groups = "JSAlert")
    public void TypeJSAlert(){
        page=new JSAlertPage();
        page.SendMessage();
        Assert.assertEquals(page.getSentJSMessage(), "You entered: This is my JS Message!!!");


    }
}
