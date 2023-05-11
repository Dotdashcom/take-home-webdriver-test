package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

import java.util.logging.Level;

public class JavaScriptError {

    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/javascript_error");
    }


    @Test
    public void testJavaScriptError(){
        BrowserUtils.waitFor(3);
        BrowserUtils.switchWindow(0);


        BrowserUtils.waitFor(3);

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().equals(Level.SEVERE)){
                String actualErrorMessage = entry.getMessage();

                if (actualErrorMessage.contains("Cannot read property 'xyz' of undefined")){
                    Assertions.assertTrue(Driver.getDriver().getPageSource().contains(actualErrorMessage));
                    break;
                }
            }
        }
    }


    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }


}
