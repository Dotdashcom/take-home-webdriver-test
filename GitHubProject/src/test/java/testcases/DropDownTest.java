package testcases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/dropdown");
	  Thread.sleep(2000);
	  WebElement dropdown = driver.findElement(By.id("dropdown"));
	  
	  Select sc =new Select(dropdown);
	  List<WebElement> options = sc.getOptions();
	  int length = sc.getOptions().size();
	  for (int i=1;i<length;i++) {
		  sc.selectByIndex(i);
		  Assert.assertEquals(options.get(i).isSelected(), true);
		  Thread.sleep(2000);
		  
	
		  }
		  
		  
	  }
		  }
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
