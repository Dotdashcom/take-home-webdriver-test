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
public class JavascriptAlertsTest
{
	
	JavascriptAlerts jsAlerts=new JavascriptAlerts();
	
    @BeforeClass
    public void launchBrowser() {
   	     jsAlerts.browserInitialization();
    }
	
     @Test
     public void verifyJavascriptAlerts() throws InterruptedException {
    	 jsAlerts.openWebPage("http://localhost:7080/javascript_alerts");
    	 String toVerify="This value has to be verified";
    	 jsAlerts.jsAlertButton.click();
    	 Alert alert = jsAlerts.driver.switchTo().alert();
    	 Assert.assertEquals(alert.getText(), "I am a JS Alert");
    	 alert.accept();
    	 Thread.sleep(2000);
    	 System.out.println("TILLL HERER");
    	 jsAlerts.jsAlertConfirm.click();
    	 Assert.assertEquals(alert.getText(), "I am a JS Confirm");
    	 alert.accept();
    	 Thread.sleep(2000);
    	 jsAlerts.jsAlertPrompt.click();   
    	 alert.sendKeys(toVerify);
    	 alert.accept();
    	 Assert.assertTrue(verifyDisplayedText("You entered: This value has to be verified"), "The javascript alert wasn't properly verified");
        }
     
     @AfterClass
     public void closeBrowser() {
    	 jsAlerts.driver.close();
     }
            
	
	public boolean verifyDisplayedText(String text) {
		String xpath="//*[contains(text(),'"+text+"')]";
		List<WebElement> elements=jsAlerts.driver.findElements(By.xpath(xpath));
		if(elements.size()>0) 
			return true;
		else
			return false;
		
		
	}
}
