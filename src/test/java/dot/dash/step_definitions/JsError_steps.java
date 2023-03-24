package dot.dash.step_definitions;

import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JsError_steps {
    @Then("verify the {string} error message")
    public void verify_the_error_message(String msg) {
        WebDriver driver = Driver.getDriver();

        // Get the browser console logs
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);



        for (LogEntry log : logs) {
            if (log.getMessage().contains(msg)) {
                Assert.assertTrue(log.getMessage().contains(msg));
                break;
            }
        }
    }
}
