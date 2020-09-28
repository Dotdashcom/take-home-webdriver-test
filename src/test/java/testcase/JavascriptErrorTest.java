package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.JavascriptAlertPage;
import pageobject.JavascriptErrorPage;

public class JavascriptErrorTest {

    private static final String ERROR_MESSAGE = "Cannot read property 'xyz' of undefined";

    private WebDriver driver;
    private JavascriptErrorPage javascriptErrorPage;


    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.javascriptErrorPage = new JavascriptErrorPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyJavaScriptAlerts() {
        Assert.assertTrue(javascriptErrorPage.verifyJSError(ERROR_MESSAGE));

    }


}
