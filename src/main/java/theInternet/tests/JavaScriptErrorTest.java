package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.JavaScriptError;

public class JavaScriptErrorTest extends TestBase {

    @Test
    public void javaScriptErrorTest(){
        JavaScriptError javaScriptError = new JavaScriptError(driver);
        String errorMsg = "Cannot read properties of undefined (reading 'xyz')";
        javaScriptError.captureError(driver,errorMsg);
    }
}
