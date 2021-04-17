package HomeWork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class JavaScriptError extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/javascript_error";

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
    }


    @Test
    public void jsError(){
        String message = "";

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries){
            System.out.println(entry.getMessage());
            if(entry.getMessage().contains("xyz")){
                message = entry.getMessage();
                message = message.substring(message.indexOf("r:")+2).trim();

            }
        }
        Assert.assertEquals(message,"Cannot read property 'xyz' of undefined");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
