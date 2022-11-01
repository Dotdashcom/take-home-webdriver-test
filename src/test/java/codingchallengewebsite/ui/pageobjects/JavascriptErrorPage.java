package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JavascriptErrorPage {
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'This page has a JavaScript error in the onload eve')]")
    public WebElement pageErrorMessage;
    private final UITest caller;
    private final String pageUrl;

    public JavascriptErrorPage(UITest caller) {
        this.caller = caller;
        WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.pageUrl = this.caller.getBaseUrl() + "//javascript_error";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        pageFactoryInitWait.until(ExpectedConditions.visibilityOf(this.pageErrorMessage));
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl); }

    public Boolean validateErrorMessage() {
        String expectedMessage = "Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
        for (LogEntry log : caller.getDriver().manage().logs().get(LogType.BROWSER)) {
            if (log.getMessage().contains(expectedMessage)) return true;
        }
        return false;
    }
}