package Test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.BrowserFactory;



public class CheckAndUncheckBoxesTest  extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void Verify_CheckedBox() 
    {   
    	driver.get("http://localhost:7080/checkboxes");
    	WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input"));
    	checkbox1.click();
    	assertTrue("checkbox1 is checked", checkbox1.isSelected()); 

    }
    @Test 
    public void Verify_UncheckedBox() 
    {	
    	driver.get("http://localhost:7080/checkboxes");
    	WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
    	checkbox2.click();
    	assertTrue("checkbox is unchecked", !checkbox2.isSelected()); 
    }
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }
    
}
