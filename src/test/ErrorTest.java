package src.test;

import org.testng.annotations.Test;
import src.main.pages.*;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ErrorTest extends BaseTest {



    private JavaScriptErrorPage javaScriptErrorPage;

    @Test
    public void javascriptErrorTest() {
        javaScriptErrorPage = Browser.open(baseURL + "javascript_error", JavaScriptErrorPage.class);
        assertTrue(javaScriptErrorPage.isErrorPresent("Cannot read properties of undefined (reading 'xyz')"));
    }


}
