package org.benjamin.pages;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.Logs;

public class JsError extends PageBase{
    public void init(){
        super.init("http://localhost:7080/javascript_error");
    }

    public LogEntries checkLogs(){
        Logs logs = driver.manage().logs();
        return logs.get("browser");
    }
}
