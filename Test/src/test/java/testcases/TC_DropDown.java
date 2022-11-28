package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DropDown extends BaseClass{
	
	
	@Test
	public void VerifyDropDown() throws InterruptedException {
		
		String url = driver.getCurrentUrl();
		driver.get(url + "/dropdown");
		
		 WebElement drp=driver.findElement(By.id("dropdown"));
	      
	      Select select = new Select(drp);
	      
	     
	     
	  /*    select.selectByVisibleText("Option 1");
	      
	      WebElement o = select.getFirstSelectedOption();
	      String selectedoption = o.getText(); 
	      if(selectedoption.equals("Option 1"))
	      {
	    	  Assert.assertTrue(true);
	      }
	      Assert.assertEquals("Option 1", selectedoption);
	      System.out.println("Selected element: " + selectedoption);
	      Thread.sleep(5000);
	      select.selectByVisibleText("Option 2");
	      Assert.assertEquals("Option 2", selectedoption);*/
		
	      for(int i=0; i<1; i++)
			{ 
	    	  select.selectByVisibleText("Option 1");
	    	  WebElement o = select.getFirstSelectedOption();
		      String selectedoption = o.getText(); 

					if(selectedoption.equals("Option 1"))
					{ 
				     	System.out.println(selectedoption + " is Selected");
						Assert.assertTrue(true);
						Thread.sleep(4000);
						select.selectByVisibleText("Option 2");
						
					}
					WebElement op = select.getFirstSelectedOption();
					String selectedoptionn = op.getText();
					System.out.println(selectedoptionn + " is Selected");	
			        Assert.assertEquals(selectedoptionn, "Option 2");
		
			}
	
	
	
	
	}	
	

}
