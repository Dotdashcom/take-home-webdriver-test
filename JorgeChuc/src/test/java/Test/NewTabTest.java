package Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.MainClass;

public class NewTabTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
		driver.get("http://localhost:7080/windows");
	}
    @Test 
    public void Verify_AbleToOpenNewTab() throws Exception
    {
    	//SearchTab
    	WebElement clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		clickHere.click();
		//VerifyNewTabDisplayed
		ArrayList<String> WindowTabs = new ArrayList<String>(driver.getWindowHandles());
    	   driver.switchTo().window(WindowTabs.get(1));
    	   assertTrue("New Window is not displayed",driver.getTitle().equals("New Window"));
       
   
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }



}
