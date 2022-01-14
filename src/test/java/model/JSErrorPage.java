package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class JSErrorPage extends PageGeneral{

    public JSErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogEntries logEntries(){
        return driver.manage().logs().get(LogType.BROWSER);
    }
}
