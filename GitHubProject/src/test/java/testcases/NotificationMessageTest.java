package testcases;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationMessageTest extends BaseTestMethods {
  @Test()
  public void Test() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	  driver.get("http://localhost:7080/notification_message_rendered");
	  WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Click here']"));
	  for (int i=0; i<4; i ++) {
		    try {
				  element.click();
				  }
		    catch(StaleElementReferenceException e) {
		  	  WebElement element2 = driver.findElement(By.xpath("//a[normalize-space()='Click here']"));
		  	  element2.click();
		    }
		    WebElement nmessage= driver.findElement(By.xpath("//div[@id='flash']"));
		    System.out.println(nmessage);
		   Thread.sleep(1000);
		   
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='flash']")));
		  }	 
	  

  }}
     


	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
