package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptError extends POBase {
    public void verifyJavaScriptError(){
        boolean success = false;
        LogEntries logEntries = BrowserUtil.GetDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries){
            System.out.println(entry.getMessage());
            if(entry.getMessage().contains("Cannot read property 'xyz' of undefined")){
                success = true;
                break;
            }
        }
        Assert.assertTrue(success);
    }
}
