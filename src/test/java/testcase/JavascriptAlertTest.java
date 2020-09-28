package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.IFramePage;
import pageobject.JavascriptAlertPage;

public class JavascriptAlertTest {

    private WebDriver driver;
    private JavascriptAlertPage javascriptAlertPage;
    private static final String textForAlert = "I am a JS Alert";
    private static final String textForConfirm = "I am a JS Confirm";
    private static final String textForPrompt = "Hello Selenium tested with Javascript alerts functions";

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.javascriptAlertPage = new JavascriptAlertPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyJavaScriptAlerts() {
        Assert.assertEquals(javascriptAlertPage.verifyJSAlert(), textForAlert);
        Assert.assertEquals(javascriptAlertPage.verifyJSConfirm(), textForConfirm);
        Assert.assertEquals(javascriptAlertPage.verifyJSPrompt(textForPrompt), textForPrompt);

    }


}
