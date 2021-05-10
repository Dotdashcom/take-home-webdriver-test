package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewWindowPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/windows";
	private WebElement openNewWindowLink;

	public NewWindowPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		openNewWindowLink = driver.findElement(By.cssSelector("a[href='/windows/new']"));
		assertTrue(openNewWindowLink.isDisplayed());
	}
	
	public NewlyOpenedWindowPage openAndSwitchToNewWindow() {
	    Set<String> currentWindows = driver.getWindowHandles();
		openNewWindowLink.click();
	    Set<String> newWindows = driver.getWindowHandles();
	    		
	    newWindows.removeAll(currentWindows);
	    assertEquals(newWindows.size(), 1);
	    
	    driver.switchTo().window(newWindows.iterator().next());
	    return new NewlyOpenedWindowPage(driver);
	}
}
