package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Util.BrowserFactory;

public class FloatingMenuTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void VerifyFloatingMenuDisplyed() throws Exception
    {
		driver.get("http://localhost:7080/floating_menu");
		WebElement menu = driver.findElement(By.xpath("//div[@id='content']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        
        //Verify Floating menu 
        assertTrue(menu.isDisplayed());
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
