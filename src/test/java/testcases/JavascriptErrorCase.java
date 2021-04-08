package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.JavascriptErrorPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class JavascriptErrorCase {
    JavascriptErrorPage javascriptErrorPage = new JavascriptErrorPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "javascript_error";
        Driver.getDriver().get(url);
    }

    @Test
    public void testErrorMessage()  {
        String errorMessage = "This page has a JavaScript error in the onload event. " +
                "This is often a problem to using normal Javascript injection techniques.";
        BrowserUtils.highlightElement(javascriptErrorPage.errorMsg);
    Assert.assertEquals(errorMessage, javascriptErrorPage.errorMsg.getText());

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}

