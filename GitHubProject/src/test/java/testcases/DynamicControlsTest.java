package testcases;

import org.testng.annotations.Test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	  driver.get("http://localhost:7080/dynamic_controls");
	  WebElement removeButton=driver.findElement(By.xpath("//button[normalize-space()='Remove']"));
	  
	  removeButton.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add']")));
	  WebElement addButton=driver.findElement(By.xpath("//button[normalize-space()='Add']"));
	  Assert.assertTrue(driver.getPageSource().contains("It's gone!"));
	  
	  addButton.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Remove']")));
	  Assert.assertTrue(driver.getPageSource().contains("It's back!"));
	  
	  WebElement typeBox =driver.findElement(By.xpath("//input[@type='text']"));
	  
	  driver.findElement(By.xpath("//button[normalize-space()='Enable']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Disable']")));
	  Assert.assertTrue(typeBox.isEnabled());
	  
	  
	 driver.findElement(By.xpath("//button[normalize-space()='Disable']")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Enable']")));
	  Assert.assertFalse(typeBox.isEnabled());



	  
	  
	  }
	  
	  }
	         
	  
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
