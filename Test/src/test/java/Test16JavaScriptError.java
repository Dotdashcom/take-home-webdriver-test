
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.JavaScriptErrorPage;

public class Test16JavaScriptError extends TestBase{
    
    @Test
    public void test16JavaScriptError(){
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(webDriver);
        
        LogEntries logEntries = javaScriptErrorPage.getErrors();
        Boolean hasError = false;
        for (LogEntry logEntry: logEntries){
            if (logEntry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")){
                hasError = true;
            }
        }
        Assert.assertTrue(hasError);
            
    }
}
