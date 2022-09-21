package utils;


import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	
	
	/**
	 * 
	 * This method allows us to call Thread.sleep() for any amount of seconds specified
	 * 
	 * @param seconds
	 */
	
	
	public static void wait(int seconds) {
		
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	


	
	
	/**
	 * 
	 * This method creates a WebDriverWait object and returns it 
	 * 
	 * @return
	 */
	
	public static WebDriverWait getWaitObject() {
		
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
		return wait;
	}
	
	
	/**
	 * 
	 * This method will wait for element to be click-able
	 * 
	 * @param element
	 * @return
	 */
	
	public static WebElement waitForClickability(WebElement element) {
		
		// create a wait object and then add the expected wait condition
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * 
	 * This method waits for an element to be visible
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility (WebElement element) {
		
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	/**
	 * 
	 * this method clicks on element once available
	 * 
	 * @param element
	 */
	
	public static void click(WebElement element) {
		
		waitForClickability(element);
		element.click();
	}
	
	
	/**
	 * 
	 * this method casts the driver to JavascriptExecutor and returns it
	 * 
	 * @return
	 */


	public static JavascriptExecutor getJSObject() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

	}

	/**
	 * 
	 * This method clears a text-box and sends another text
	 * 
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);
		
	}
	
	/**
	 * 
	 * this method will click to the element that is passed using JavascriptExecutor
	 * 
	 * @param element
	 */
	
	public static void jsClick(WebElement element) {

		getJSObject().executeScript("arguments[0].click();", element);
	}
	
	
	
}
	

