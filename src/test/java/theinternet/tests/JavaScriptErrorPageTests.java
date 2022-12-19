package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.JavaScriptErrorPage;

public class JavaScriptErrorPageTests extends BaseTest{
    JavaScriptErrorPage javaScriptErrorPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToJavaScriptErrorPage();
        javaScriptErrorPage = new JavaScriptErrorPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testJavaScriptErrorPageLanding(){
        Assert.assertTrue(javaScriptErrorPage.validatePageLanding(), "Java script error page not loaded");
    }

    @Test(priority = 1)
    public void testJavaScriptError(){
        String jsError = "Cannot read properties of undefined (reading 'xyz')";
        Assert.assertTrue(javaScriptErrorPage.containsJavaScriptError(jsError), "JavaScript error is not found");
    }
}
