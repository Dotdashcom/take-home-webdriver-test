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
public class WindowsTest
{
	
	Windows windows=new Windows();
	WebDriverWait wait;
	
    @BeforeClass
    public void launchBrowser() {
   	     windows.browserInitialization();
   	     wait = new WebDriverWait(windows.driver,30);
    }
	
    @Test
    public void verifyOpenNewTab() {
     windows.openWebPage("http://localhost:7080/windows");
   	 Assert.assertTrue(windows.driver.getWindowHandles().size() == 1, "There's more than one ");
   	 windows.clickHereButton.click();
   	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
   	 Assert.assertTrue(windows.driver.getWindowHandles().size() == 2, "A new window wasn't opened");
                 	
       }
    
    @AfterClass
    public void closeBrowser() {
   	 windows.driver.close();
    }
}
