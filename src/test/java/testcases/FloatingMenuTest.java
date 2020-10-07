package testcases;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class FloatingMenuTest extends TestBase {
	
	public FloatingMenuTest() throws IOException {
		super();	
	}
	
	@Test  
	public void verifyFloatingMenu()
	{
		driver.get(urlvalues.url_floating);
		System.out.println("before scroll down");
		
		//using Assertion to test 
		Assert.assertTrue(data.floatingmenu.isDisplayed());
		
		//use of JavascriptExecutor to scroll in window 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,2600)");
		 System.out.println("After Scroll down ");
		 Assert.assertTrue(data.floatingmenu.isDisplayed());
		 System.out.println("Floating menu is visible ");
	}
}
