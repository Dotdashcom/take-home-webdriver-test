package pageobject;

import base.EndPointPath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import utilities.JavascriptUtilities;

import java.util.List;

public class JavascriptErrorPage extends BasePage {

    public JavascriptErrorPage(WebDriver driver) {
        super(driver, EndPointPath.JAVASCRIPT_ERROR);

    }


    public boolean verifyJSError(String errorMessage) {
        List<LogEntry> logs = JavascriptUtilities.getBrowserConsoleLogs(driver);
        return logs.stream().anyMatch(log -> log.getMessage().contains(errorMessage));
    }



}
