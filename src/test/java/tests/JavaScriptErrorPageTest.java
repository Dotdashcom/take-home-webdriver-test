package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.JavaScriptErrorPage;

public class JavaScriptErrorPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "javascriptErrorUrl", "javaScriptErrorMessage"})
    public void javaScript_Error_Test(String baseUrl, String javascriptErrorUrl, String javaScriptErrorMessage) {
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        javaScriptErrorPage.goToUrl(baseUrl, javascriptErrorUrl);

        Assert.assertTrue(javaScriptErrorPage.getJsErrorMessage().contains(javaScriptErrorMessage));
    }
}
