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
public class LoginTest
{
	
	Login login=new Login();
	
    @BeforeClass
    public void launchBrowser() {
   	     login.browserInitialization();
    }
    
	@Test
    public void verifyLogin() {
		login.openWebPage("http://localhost:7080/login");
    	login.username.sendKeys("tomsmith");
    	login.password.sendKeys("SuperSecretPassword!");
    	login.login.click();
        Assert.assertEquals(verifyDisplayedText("You logged into a secure area!"), true);
    	
    }
	
	@Test
    public void verifyLoginWithInvalidCreds() {
		login.openWebPage("http://localhost:7080/login");
    	login.username.sendKeys("tomsmithInvalid");
    	login.password.sendKeys("SuperSecretPassword!Invalid");
    	login.login.click();
        Assert.assertEquals(verifyDisplayedText("Your username is invalid!"), true);
        
    	
    }
	
	public boolean verifyDisplayedText(String text) {
		String xpath="//*[contains(text(),'"+text+"')]";
		List<WebElement> elements=login.driver.findElements(By.xpath(xpath));
		if(elements.size()>0) 
			return true;
		else
			return false;
		
		
	}
	
    @AfterClass
    public void closeBrowser() {
   	 login.driver.close();
    }

}
