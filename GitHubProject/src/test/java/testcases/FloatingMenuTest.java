package testcases;

import org.testng.annotations.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FloatingMenuTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/floating_menu");
	  WebElement floatingElement= driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	  System.out.println(floatingElement.getText());
	  js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1800);");
	  
	  Assert.assertTrue(floatingElement.isDisplayed());
		  

	  }
	  
	  }
	         
	  
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
