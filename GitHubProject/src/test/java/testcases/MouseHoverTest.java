package testcases;

import org.testng.annotations.Test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseHoverTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/hovers");
	  
	  Actions actions = new Actions(driver);
	 
	  List<WebElement> profiles = driver.findElements(By.xpath("//*[@alt=\"User Avatar\"]"));
	  for (int i=0;i<profiles.size();i++) {
		  actions.moveToElement(profiles.get(i)).perform();
		  Thread.sleep(1000);
		  WebElement link= driver.findElement(By.linkText("View profile"));
		  Assert.assertTrue(link.isDisplayed());
		  

	  }
	  
	  }
	         
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
