package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.Driver;
import util.UI_Util;

public class JavaScriptError extends Driver {

    @Test
    public void javascript_error_test() {
        Driver.getDriver().get("http://localhost:7080/javascript_error");

        String expectedErrorMsg = "Cannot read properties of undefined (reading 'xyz')";

        Assert.assertTrue(UI_Util.JSLogsInfoTest(expectedErrorMsg) , "error message does not match the expected error message");
    }
}
