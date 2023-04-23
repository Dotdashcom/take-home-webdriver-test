import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class JSErrorPage extends BasePage {
    private String path = "/javascript_error";

    private By jsAlertButtonBy = By.xpath("//button[contains(text(), \"JS Alert\")]");
    private By jsConfirmButtonBy = By.xpath("//button[contains(text(), \"JS Confirm\")]");
    private By jsPromptButtonBy = By.xpath("//button[contains(text(), \"JS Prompt\")]");
    private By resultBy = By.xpath("//p[@id=\"result\"]");

    private LogEntries entries;

    JSErrorPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void saveErrorLog() {
        entries = driver.manage().logs().get(LogType.BROWSER);

        entries.getAll().stream().filter(logEntry -> logEntry.getLevel().intValue() >= Level.SEVERE.intValue()).collect(Collectors.toList());
    }

    public LogEntries getErrorLog() {
        return entries;
    }

    public boolean logContainsError(String errorText) {
        boolean doesContain = false;
        for (LogEntry entry : entries) {
            if (entry.getMessage().contains(errorText))
                doesContain = true;
        }
        return doesContain;
    }
}
