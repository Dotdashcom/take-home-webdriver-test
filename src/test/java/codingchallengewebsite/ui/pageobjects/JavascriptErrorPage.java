package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class JavascriptErrorPage {

    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public JavascriptErrorPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("//javascript_error").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() { // Check that the page loaded
        return this.driver.getCurrentUrl().equals(this.pageUrl); }

    public boolean validateErrorMessage() {
        String expectedMessage = "Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
        for (LogEntry log : driver.manage().logs().get(LogType.BROWSER)) {
            if (log.getMessage().contains(expectedMessage)) return true;
        }
        return false;
    }
}
