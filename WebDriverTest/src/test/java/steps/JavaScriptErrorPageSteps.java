package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class JavaScriptErrorPageSteps extends Functions {


    @Then("user sees the error and verifies {string}")
    public void user_sees_the_error_and_verifies(String jsErrorExpected) {

        Assert.assertTrue(javaScriptErrorPage.jsError.getText().contains(jsErrorExpected));

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logEntries.getAll()) {
            System.out.println(log);
        }
    }
}
