package testcases;

import org.testng.annotations.Test;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewTabTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/windows");
	  driver.findElement(By.cssSelector("#content > div > a")).click();
	  String mainHandle=driver.getWindowHandle();
	  Set <String> handles = driver.getWindowHandles();
	  for (String handle:handles) {
		  if (!handle.equals(mainHandle)) {
			  driver.switchTo().window(handle);
			  WebElement header=driver.findElement(By.cssSelector("body > div > h3"));
			  Assert.assertTrue(header.getText().equals("New Window"));
			  driver.close();
		  }
	  }
	  driver.switchTo().window(mainHandle);
	  

	  }
	         
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
