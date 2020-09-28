package LocalHost.Tests;

import LocalHost.Pages.JSErrorPage;
import org.testng.annotations.Test;

public class JSError extends TestingBase {

    @Test(groups = "JSError")
    public void RetrieveError(){
        JSErrorPage.retrieveJSLogs();
    }

}
