package Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Util.BrowserFactory;

public class DropDownTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void Verify_SelectDropDown() throws Exception 
    {   
    	driver.get("http://localhost:7080/dropdown");
     	WebElement dropDown = driver.findElement(By.id("dropdown"));
        WebElement Option1 =driver.findElement(By.xpath("//*[@id='dropdown']/option[2]"));
        WebElement Option2 =driver.findElement(By.xpath("//*[@id='dropdown']/option[3]"));
        
        
        //Option 1
     	Select dd = new Select(dropDown);
     	dd.selectByVisibleText("Option 1");
     	
     	if(Option1.getAttribute("selected")!=null)
     		assertTrue("Option 1 is selected",true); 
     	else 
        assertTrue("Option 1 is Not selected", false);
     	
     	
     	//Option 2
     	dd.selectByVisibleText("Option 2");

     	if(Option2.getAttribute("selected")!=null)
     		assertTrue("Option 2 is selected",true); 
     	else 
        assertTrue("Option 2 is Not selected", false);
    }

    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }


}
