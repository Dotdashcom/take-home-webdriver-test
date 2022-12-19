package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.FileDownloadPage;
import theinternet.pages.JavaScriptAlertPage;

public class JavaScriptAlertPageTests extends BaseTest{
    JavaScriptAlertPage javaScriptAlertPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToJavaScriptAlertsPage();
        javaScriptAlertPage = new JavaScriptAlertPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(javaScriptAlertPage.validatePageLanding(), "JavaScript alert page not loaded");
    }

    @Test(priority = 1)
    public void testAlert() throws InterruptedException {
        Assert.assertEquals(javaScriptAlertPage.getAlertText(), "I am a JS Alert", "Alert text does not match");
    }

    @Test(priority = 2)
    public void testConfirm() throws InterruptedException {
        Assert.assertEquals(javaScriptAlertPage.getConfirmText(), "I am a JS Confirm", "Confirm text does not match");
    }

    @Test(priority = 3)
    public void testPrompt() throws InterruptedException {
        String myText = "ice cream";
        Assert.assertEquals(javaScriptAlertPage.typeAndReturnTextPrompt(myText), "You entered: ice cream", "Result text does not match");
    }
}
