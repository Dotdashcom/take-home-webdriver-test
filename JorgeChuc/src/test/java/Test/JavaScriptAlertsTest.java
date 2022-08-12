package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Util.MainClass;

public class JavaScriptAlertsTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
		driver.get("http://localhost:7080/javascript_alerts");
	}
    @Test 
    public void Verify_AdditionalInfoDisplyedWhenHoverOver() throws Exception 
    {
		// elements for alerts buttons
    	WebElement JSAlert = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
    	WebElement JSConfirmn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
    	WebElement JSPrompt = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));

		//act
    	JSAlert.click();
    	
    	//Verify
    	 try
		   { 
		  		driver.switchTo().alert().accept();
		  		Thread.sleep(1000);
		  		assertTrue(true); //alert displayed
		   }
		   catch(NoAlertPresentException ex){assertTrue(false);}

		//act
		JSConfirmn.click();
		//verify confirm pop up

		 try
		   { 
		  		driver.switchTo().alert().accept();
		  		Thread.sleep(1000);
		  		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();
		  		assertTrue(msg.equals("You clicked: Ok")); //alert displayed
		   }
		   catch(NoAlertPresentException ex){assertTrue(false);}
			//act
			JSConfirmn.click();
			//verify dismiss pop up

			 try
			   { 
			  		driver.switchTo().alert().dismiss();
			  		Thread.sleep(1000);
			  		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();
			  		assertTrue(msg.equals("You clicked: Cancel")); //alert displayed
			   }
			   catch(NoAlertPresentException ex){assertTrue(false);}
		
		//act 
		JSPrompt.click();
    try {
		
 	    	Alert alert = driver.switchTo().alert();
		    alert.sendKeys("test!");
 	     	alert.accept();
 	    	String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();
     		assertTrue(msg.equals("You entered: test!"));
  		
        }
    catch(NoAlertPresentException ex){assertTrue(false);}
	
		
  		;
	

   
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }


}
