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
public class FloatingMenuTest
{
	
	FloatingMenu floatingMenu=new FloatingMenu();
	WebDriverWait wait;
	
    @BeforeClass
    public void launchBrowser() {
   	     floatingMenu.browserInitialization();
   	     wait = new WebDriverWait(floatingMenu.driver,30);
    }
	
    @Test
    public void verifyScrolling() {
    floatingMenu.openWebPage("http://localhost:7080/floating_menu"); 
   	Assert.assertTrue(floatingMenu.floatingMenu.isDisplayed(), "Floating Menu is not displayed");
   	JavascriptExecutor jse = (JavascriptExecutor)floatingMenu.driver;
    jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    Assert.assertTrue(floatingMenu.floatingMenu.isDisplayed(), "Floating Menu is not displayed");
                 	
       }
    
	@AfterClass
	public void closeBrowser() {
		floatingMenu.driver.close();
	}
}
