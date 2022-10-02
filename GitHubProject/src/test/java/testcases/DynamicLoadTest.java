package testcases;

import org.testng.annotations.Test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/dynamic_loading/2");
	  WebElement start= driver.findElement(By.cssSelector("#start > button"));
	  start.click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish > h4")));
	  WebElement helloworld = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
	  
	  Thread.sleep(1000);
	  Assert.assertEquals(helloworld.getText(), "Hello World!");
	  
	  }
	         
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
