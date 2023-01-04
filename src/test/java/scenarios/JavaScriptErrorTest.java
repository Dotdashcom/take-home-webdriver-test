package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.JavaScriptErrorPage;

public class JavaScriptErrorTest extends BaseTest {
    private JavaScriptErrorPage javaScriptErrorPage;

    @BeforeMethod
    public void setup() {
        javaScriptErrorPage = homePage.gotoJavaScriptErrorPage();
    }

    @Test
    public void verifyPageContainsJSError() {
        String jsError = "Cannot read properties of undefined (reading 'xyz')";
        boolean isJSErrorPresent = javaScriptErrorPage.isErrorPresent(jsError);
        Assert.assertTrue(isJSErrorPresent, "Page should contain a JS error!");
    }
}