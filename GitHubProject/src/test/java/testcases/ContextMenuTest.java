package testcases;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ContextMenuTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/context_menu");
	  
	 WebElement ContextMenuBox= driver.findElement(By.id("hot-spot"));
	 Actions action = new Actions(driver);
	 
	 action.contextClick(ContextMenuBox).perform();
	  Thread.sleep(2000);
	  String alertMessage=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  //System.out.println(alertMessage);
	  Assert.assertEquals("You selected a context menu", alertMessage);
	  driver.switchTo().defaultContent();
	 
		  
		  
		  
		  
	  }}