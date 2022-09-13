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
public class IframeTest
{
	
	Iframe iframe=new Iframe();
	
    @BeforeClass
    public void launchBrowser() {
   	     iframe.browserInitialization();
    }
	
    @Test
    public void verifyIframe() throws InterruptedException {
   	 iframe.openWebPage("http://localhost:7080/iframe");
   	 String text="Verifying the iframe";
   	 iframe.closeButton.click();
   	 Thread.sleep(2000);
   	 iframe.driver.switchTo().frame(iframe.iframe);
   	 iframe.iframeParagraphBox.clear();
   	 iframe.iframeParagraphBox.sendKeys(text);
   	 Assert.assertTrue(iframe.iframeParagraphBox.getText().contentEquals(text), "Text in the iframe is not correct");
                 	
       }
    
	@AfterClass
	public void closeBrowser() {
		iframe.driver.close();
	}
}
