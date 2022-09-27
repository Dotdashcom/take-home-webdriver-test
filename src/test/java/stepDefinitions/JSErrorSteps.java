package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.JSErrorPage;
import utils.PropertyKeys;

import java.time.Duration;

public class JSErrorSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private JSErrorPage jsErrorPage;

    public JSErrorSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        jsErrorPage = new JSErrorPage(driver, wait);
    }

    @Given("user navigates to JS error page")
    public void navigateToJSErrorPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/javascript_error");
        jsErrorPage.WaitUntilElementVisible(jsErrorPage.jsErrorPageText);
    }

    @Then("page contains errors")
    public void validatePageContainsErrors() {
        boolean jsError = false;
        LogEntries logs = driver.manage().logs().get("browser");
        for (LogEntry log : logs) {
            System.out.println("error log: " + log.getMessage());
            if (log.getMessage().contains("Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')")) {
                jsError = true;
            }
        }
        Assert.assertTrue(jsError);
    }
}
