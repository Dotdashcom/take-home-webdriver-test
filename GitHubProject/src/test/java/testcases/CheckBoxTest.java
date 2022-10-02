package testcases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/checkboxes");
	  Thread.sleep(2000);
	  
	  List<WebElement> checkBoxes=driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
	  for (int i=0;i<checkBoxes.size();i++) {
		  if (checkBoxes.get(i).isSelected()== false){
			  checkBoxes.get(i).click();
			  Thread.sleep(2000);
			  Assert.assertEquals(true, checkBoxes.get(i).isSelected());
		  }
		  else {
			  checkBoxes.get(i).click();
			  Thread.sleep(2000);

			  Assert.assertEquals(true, checkBoxes.get(i).isSelected());

		  }
		  
		  
		  
		  
	  }
	
	 
	 
	  
	  
	  
	  
	  
	  
  }

}
