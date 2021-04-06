package TakeHome.tests;


import TakeHome.pages.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSErrorTest extends TestBase {

    @Test(groups = "JSError")
    public void RetrieveError(){
        for (LogEntry entry : JSErrorPage.retrieveJSLogs()) {
                 Assert.assertTrue(entry.toString().contains("Cannot read property 'xyz' of undefined"));
            }
        }

}
