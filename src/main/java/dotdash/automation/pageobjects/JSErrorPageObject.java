package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class JSErrorPageObject extends BasePageObject {
    public JSErrorPageObject(WebDriver driver) {
        super(driver);
    }

    public List<String> getErrList() {
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        List<String> errList = new ArrayList<>();
        for (LogEntry entry : logEntries) {
            errList.add(entry.getMessage());
        }
        return errList;
    }
}
