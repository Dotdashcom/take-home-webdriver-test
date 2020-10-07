package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.JavascriptErrorPage;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;


//TestCase Description: JavaScript Error: http://localhost:7080/javascript_error Test JS error.
public class TC16_JavascriptError extends baseClass{

    @Test
    public void javascriptError() {
        //Launch url
        driver.get(baseURL+"/javascript_error");

        JavascriptErrorPage javascriptErrorPage = new JavascriptErrorPage(driver);
        SoftAssert assertion = new SoftAssert();
        //Validate whether the Javascript error message is displayed
        assertion.assertTrue(javascriptErrorPage.gettxterror().contains("JavaScript error in the onload event"));

        // Mention the type of Log
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        // Retrieve all logs
        List<LogEntry> logs= entry.getAll();
        // Print one by one
        for(LogEntry e: logs)
        {
            System.out.println(e);
        }
        // Print and Validate the console error message
        for(LogEntry e: logs)
        {
            System.out.println("Message is: " +e.getMessage());
            assertion.assertTrue(e.getMessage().contains("Cannot read property 'xyz' of undefined"));

            System.out.println("Level is: " +e.getLevel());
        }
        assertion.assertAll();
    }

}





