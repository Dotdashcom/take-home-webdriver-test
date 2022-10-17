package Assignment;

import Utilities.TestBase;
import Utilities.UI_Methods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptError extends TestBase {

    @Test
    public void javaScriptErrorTest(){

        driver.get(baseUrl + "/javascript_error");

        String expectedErrorMsg = "Cannot read properties of undefined (reading 'xyz')";

        Assert.assertTrue(JSLogsInfoTest(expectedErrorMsg) , "error message does not match!");
    }
    }

