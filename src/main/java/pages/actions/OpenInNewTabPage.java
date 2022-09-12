package pages.actions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import base.Page;

public class OpenInNewTabPage extends Page{
	
	public void verifyNewWindow() {
		click(locators.newTabClick);
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iter = allWindows.iterator();
		while(iter.hasNext()) {
			String childWindow = iter.next();
			if(!allWindows.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "http://localhost:7080/windows/new";
		
		System.out.println("actual url:"+ actualURL);
		
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	
	
	

}
