package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class JavascriptErrorPage {

    private final UITest caller;
    private final String pageUrl;

    public JavascriptErrorPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "//javascript_error";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() { // Check that the page loaded
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl); }

    public boolean validateErrorMessage() {
        String expectedMessage = "Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
        for (LogEntry log : caller.getDriver().manage().logs().get(LogType.BROWSER)) {
            if (log.getMessage().contains(expectedMessage)) return true;
        }
        return false;
    }
}