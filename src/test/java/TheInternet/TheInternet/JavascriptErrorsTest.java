package TheInternet.TheInternet;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class JavascriptErrorsTest
{
	
	JavascriptErrors jsErrors=new JavascriptErrors();
	
    @BeforeClass
    public void launchBrowser() {
   	     jsErrors.browserInitialization();
    }
	

     @Test
     public void verifyJavascriptErrors() {
    	 jsErrors.openWebPage("http://localhost:7080/javascript_error"); boolean flag=false;
    	 LogEntries logEntries = jsErrors.driver.manage().logs().get(LogType.BROWSER);
         List<LogEntry> lg = logEntries.filter(Level.ALL);
         for(LogEntry logEntry : lg) {
        	 System.out.println(logEntry);
        	if(logEntry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
        		Assert.assertTrue(true, "The log message wasn't displayed");
        		flag=true;
        		break;
        	}
         }
         if(flag==false) {
        	 Assert.assertTrue(false, "The log message wasn't displayed");
         }
                  	
        }
     
     @AfterClass
     public void closeBrowser() {
    	 jsErrors.driver.close();
     }
     

}
