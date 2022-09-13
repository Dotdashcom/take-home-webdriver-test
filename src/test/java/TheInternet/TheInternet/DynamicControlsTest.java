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
public class DynamicControlsTest
{
	
	DynamicControls dynamicControls=new DynamicControls();
	WebDriverWait wait;
	
    @BeforeClass
    public void launchBrowser() {
   	     dynamicControls.browserInitialization();
   	     wait = new WebDriverWait(dynamicControls.driver,30);
    }
	
    @Test
    public void verifyDynamicControls() throws InterruptedException {
     dynamicControls.openWebPage("http://localhost:7080/dynamic_controls");
     dynamicControls.swapCheckboxButton.click();
   	 wait.until(ExpectedConditions.visibilityOf(dynamicControls.addButton));
   	 Assert.assertEquals(verifyDisplayedText("gone!"), true);
   	 Thread.sleep(2000);
   	 dynamicControls.swapCheckboxButton.click();
   	 wait.until(ExpectedConditions.visibilityOf(dynamicControls.dynamicControlsCheckbox));
   	 Assert.assertEquals(verifyDisplayedText("back!"), true);
   	 Thread.sleep(2000);
   	 dynamicControls.swapInputButton.click();
   	 wait.until(ExpectedConditions.visibilityOf(dynamicControls.enableButton));
   	 Assert.assertEquals(verifyDisplayedText("enabled!"), true);
   	 Thread.sleep(2000);
   	 dynamicControls.swapInputButton.click();
   	 wait.until(ExpectedConditions.elementToBeClickable(dynamicControls.dynamicControlsBar));
   	 Assert.assertEquals(verifyDisplayedText("disabled!"), true);
           
       	
       }
	
	

	public boolean verifyDisplayedText(String text) {
		String xpath="//*[contains(text(),'"+text+"')]";
		List<WebElement> elements=dynamicControls.driver.findElements(By.xpath(xpath));
		if(elements.size()>0) 
			return true;
		else
			return false;
		
		
	}
	
	@AfterClass
	public void closeBrowser() {
		dynamicControls.driver.close();
	}

}
