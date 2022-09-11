package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptError {

    public JavaScriptError(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "JavaScript onload event error")
    WebElement JSError;


    public void captureError(WebDriver driver, String message){
        JSError.click();
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        boolean contains = false;

        for (LogEntry log:logEntries){
            if (log.getMessage().contains(message)){
                contains=true;
            }
        }
        Assert.assertTrue(contains);
    }
}
