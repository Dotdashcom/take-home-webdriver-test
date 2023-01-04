package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class Page extends BasePage {
    public Page(ChromeDriver driver) {
        super(driver);
    }
    public boolean isErrorPresent(String error) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getMessage().contains(error)) {
                return true;
            }
        }
        return false;
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void switchToWindow(Set<String> windowHandles, int nbWindows) {
        new WebDriverWait(driver, BasePage.ACTION_TIMEOUT).until(ExpectedConditions.numberOfWindowsToBe(nbWindows));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandles.contains(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
