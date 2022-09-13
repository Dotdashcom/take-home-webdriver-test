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
public class NotificationMessageTest
{
	
	NotficationMessage notificationMessage=new NotficationMessage();
	
    @BeforeClass
    public void launchBrowser() {
   	     notificationMessage.browserInitialization();
    }
	
     
     @Test
     public void verifyNotificationMessage() throws InterruptedException {
    	 notificationMessage.openWebPage("http://localhost:7080/notification_message_rendered");
    	 String[] status= {"Action successful", "Action unsuccessful", "Action unsuccesful, please try again"};
    	 List<String> statusList = Arrays.asList(status); 
    	 for(int x=0;x<10;x++) {
            notificationMessage.clickHereLink.click();
    	    Thread.sleep(1000);   
    	    String flashMessage=notificationMessage.flashMessage.getText();
    	    Assert.assertTrue(statusList.contains(flashMessage.replace("\n", "").replace("\r", "").trim().substring(0, flashMessage.length() - 2)), "The status was different");
    	 }
    	 
                  	
        }
     
     @AfterClass
     public void closeBrowser() {
    	 notificationMessage.driver.close();
     }
     

}
