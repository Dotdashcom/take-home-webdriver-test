package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_JavascriptError extends BaseTestClass {


    @Test
    public void TC_JavaScriptError_001_Validate_JavaScriptErrorOnPage() {
        ActionHelper.openUrl(Constants.JAVASCRIPT_ERROR_PAGE_URL);
        Assert.assertTrue(ActionHelper.getBrowserLogs()
                .contains("Cannot read properties of undefined (reading 'xyz')"), "Validate Error Logs");
    }

}
