package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class JavaScriptErrorPage extends BasicPage {
    WebDriver driver;

    public JavaScriptErrorPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/javascript_error");
        PageFactory.initElements(this.driver, this);
    }

    public void assertJSError(String ExpectedError) {
        List<LogEntry> logs = this.driver.manage().logs().get(LogType.BROWSER).getAll();
        for (LogEntry log : logs) {
            if (log.getMessage().contains(ExpectedError)) {
                return;
            }
        }
        Assert.fail("Cannot find the required JavaScript error" + ExpectedError);
    }
}
