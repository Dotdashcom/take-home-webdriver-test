package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import Util.BrowserFactory;

public class IFrameTest extends BrowserFactory{
	
	@Before
    public void Setup()
	{
		startBrowser();
		driver.get("http://localhost:7080/iframe");
	}
	
	@Test 
	public void Verify_TypedTextIsAsExpected() 
	{
		   try
		   {    //close elart pop up 
		  		driver.switchTo().alert();
		  		driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
		  		
		       }
		   catch(NoAlertPresentException ex){}
		    	  
		//act
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("Good Morning!");
		
		
		//assert that the typed text is as expected.
		String Text = driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
		if(Text.equals("Good Morning!")) { assertTrue(true);}
		else assertTrue(false);
	}
	
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
