package Pages;

import Utils.Driver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class JavaScriptErrorPage {
    public JavaScriptErrorPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }


    public void ErrorFound() {
        LogEntries logEntries = Driver.GetDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Print all log "+logEntries.getAll());
        System.out.println("print index 0 log "+logEntries.getAll().get(0));
        Assert.assertTrue(logEntries.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
    }
}

