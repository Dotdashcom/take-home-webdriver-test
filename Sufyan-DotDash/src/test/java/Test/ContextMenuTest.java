package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.BrowserFactory;

public class ContextMenuTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void Verify_ContextMenuDisplyed() 
    {   
    	driver.get("http://localhost:7080/context_menu");
    	//Perform right click
    	Actions ac = new Actions(driver);
    	WebElement contextMenu = driver.findElement(By.id("hot-spot"));
    	ac.contextClick(contextMenu).perform();
        // Explicit wait condition for alert
        WebDriverWait w = new WebDriverWait(driver, 5);
        if(w.until(ExpectedConditions.alertIsPresent())==null)
        assertTrue("Alert not exists", false);
        else
        	assertTrue("Alert exists",true); 

    }

    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
