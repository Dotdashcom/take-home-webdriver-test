package regression.ui.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public final class JavascriptErrorPage extends WebObject {
    public JavascriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public static JavascriptErrorPage navigateToJavascriptErrorPage(WebDriver driver, String baseUrl) {
        String url = String.format("%s/javascript_error", baseUrl);
        driver.get(url);
        return new JavascriptErrorPage(driver);
    }

    public String getErrorMessage() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        String message = "";
        for (LogEntry entry : logEntries) {
            message = entry.getMessage();
        }
        return message;
    }

}
