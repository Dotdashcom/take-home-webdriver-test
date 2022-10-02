package testcases;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicContentTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	  driver.get("http://localhost:7080/dynamic_content");
	  Thread.sleep(2000);
	  //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div"));
	  String data = element.getText();
	  driver.navigate().refresh();
	  try {
		  wait.until(ExpectedConditions.visibilityOf(element));
		  }
    catch(StaleElementReferenceException e) {
  	  WebElement element1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div"));
	  String data2 = element1.getText();
	  wait.until(ExpectedConditions.visibilityOf(element1));
		 Assert.assertNotSame(data2, data, "Test passed");

    }
  		}
		  
		  
	  }
		  
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
