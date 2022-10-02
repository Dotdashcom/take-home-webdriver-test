package testcases;

import org.testng.annotations.Test;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JavaScriptAlertTest extends BaseTestMethods {
	
  @Test(priority=1)
  public void JSAlertTest() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/javascript_alerts");
	 
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	  Alert alert = driver.switchTo().alert();
	  String text=alert.getText();
	  System.out.println(text);
	  Assert.assertTrue(text.contains("I am a JS Alert"));
	  alert.accept();
	  }
  @Test(priority =2)
  public void JSConfirmTest() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/javascript_alerts");
	 
	  driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	  Alert alert = driver.switchTo().alert();
	  String text=alert.getText();
	  System.out.println(text);
	  Assert.assertTrue(text.contains("I am a JS Confirm"));
	  alert.accept();
	  }
	       
  @Test(priority =3)
  public void JSPromptTest() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/javascript_alerts");
	 
	  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	  Alert alert = driver.switchTo().alert();
	  alert.sendKeys("The prompt message");
	  alert.accept();
	  WebElement result= driver.findElement(By.id("result"));
	  Assert.assertTrue(result.getText().contains("The prompt message"));
	  
	  }
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
