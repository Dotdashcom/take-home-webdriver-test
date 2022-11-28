package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_OpenInNewTab extends BaseClass {
	
@Test	
	public void VerifyIFrames() {
		
		
		driver.get("http://localhost:7080/windows");
	      
	    WebElement clickhere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		String originalWindow = driver.getWindowHandle();

	
		assert driver.getWindowHandles().size() == 1;

		
		driver.findElement(By.linkText("Click Here")).click();

		
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		       System.out.println(driver.switchTo().window(windowHandle).getTitle());
		       Assert.assertEquals("New Window",driver.switchTo().window(windowHandle).getTitle() );
		   
		        break;
		    }
		}
	}
	
	
	

}
