package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.JavaScriptError;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JsErrorTest extends BasePage {
    JavaScriptError je;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.JSError);
        je=new JavaScriptError();
    }
    @Test
    public void JavaScriptError(){
        Assert.assertTrue(je.isError());
    }
    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
