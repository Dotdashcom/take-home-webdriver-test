package com.automation.pageobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewTabPage {
	public static final By NEWTABHEADER=By.xpath("//h3[text()='Opening a new window']");
	public static final By CLICKHERE=By.xpath("//a[text()='Click Here']");
	public static final By NEWWINDOWHEADER=By.xpath("//div[@class='example']/h3");
	
	
	
	
	
	public static void validateNewWindowHeader(WebDriver driver) {
		WebElement element= driver.findElement(NEWTABHEADER);
		Assert.assertTrue(element.isDisplayed(), "new window Header is not Displaying");
	}

	public static void clickHereAndValidateNewWindow(WebDriver driver) {
	
		String parentWindow=driver.getWindowHandle();
		driver.findElement(CLICKHERE).click();
		Set<String> windowHandles=driver.getWindowHandles();
		
		for(String handle  : windowHandles)
	       {
	       if(!handle.equals(parentWindow)) {
	    	   driver.switchTo().window(handle); 
	    	   Assert.assertEquals(driver.findElement(NEWWINDOWHEADER).getText(), "New Window");
	    	   driver.close(); 
	           driver.switchTo().window(parentWindow);
	       }
		
	       }
		
	}
	
	
}
