package testcases;

import org.testng.annotations.Test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IframeTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/iframe");
	  String text="This is a test text";
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[name()='path' and contains(@d,'M17.3 8.2L')]")));
	  driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M17.3 8.2L')]")).click();
	  
      driver.switchTo().frame("mce_0_ifr");      
      driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).clear();
      
      driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys(text);
      String enteredText=(driver.findElement(By.id("tinymce")).getText());
      Assert.assertEquals(enteredText, text);
      

	 
	
	  
	  }
	         
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
