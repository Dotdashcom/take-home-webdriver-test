package javascript_error_page_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.javascript_error_page.JavaScriptErrorPage;

import static org.testng.Assert.assertEquals;

public class JavaScriptErrorTest extends Base {
    @Test
    public void javascriptErrorTest() {
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();
//      javaScriptErrorPage.catchJavascriptError();
        String actualErrorMessage = javaScriptErrorPage.getJsError();
        String expectedErrorMessage = "Cannot read properties of undefined (reading 'xyz')";
        assertEquals(actualErrorMessage,expectedErrorMessage);
    }

}
