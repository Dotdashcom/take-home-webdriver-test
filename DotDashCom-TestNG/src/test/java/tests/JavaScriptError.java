package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.JavaScriptErrorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import static utilities.Driver.driver;


public class JavaScriptError {

    JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"javascript_error");
        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();

        String searchedError="";
        int index=1;
        for (int i=0; i<logs.size(); i++){
            System.out.println(("The "+index+". Error in the page is=> "+ logs.get(i)));
            if (logs.get(i).toString().contains("Cannot read property 'xyz' of undefined")){
                searchedError = logs.get(i).toString();}
            index++;
        }

        Assert.assertFalse(searchedError.contains("Cannot read property 'xyz' of undefined"));


        }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
