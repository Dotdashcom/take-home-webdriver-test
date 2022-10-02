package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	 
	  
	  driver.get("http://localhost:7080/drag_and_drop");
	  
	 WebElement a= driver.findElement(By.xpath("//div[@id='column-a']"));
	 WebElement b= driver.findElement(By.xpath("//div[@id='column-b']"));

	
	  Actions builder = new Actions(driver);

	    Action dragAndDrop = builder.clickAndHold(a)
	       .moveToElement(b)
	       .release(b)
	       .build();

	    dragAndDrop.perform();
	  Thread.sleep(2000);
	  if (a.getText()!=b.getText()) {
		  Assert.assertTrue(a.getText()!=b.getText());
	  }

	 	  
	  }}