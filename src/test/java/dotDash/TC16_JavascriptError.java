package dotDash;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class TC16_JavascriptError extends BaseClass {

    @Test
    public void javascripterror() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "JavascriptError");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        boolean found = false;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            String actMsg = logEntry.getMessage();
            if (logEntry.getMessage().contains("Cannot read property 'xyz' of undefined")) {
                found = true;
                break;
            }
        }
        // Validate using assert
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(found);
        assertion.assertAll();
    }
}
