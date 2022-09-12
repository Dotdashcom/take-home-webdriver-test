package pages.actions;

import org.openqa.selenium.Alert;
import org.testng.Assert;

import base.Page;

public class JavaScriptAlertsPage extends Page{
	
	
	public void verifyJSAlert() {
		click(locators.JSAlert);
		Alert alert = driver.switchTo().alert();
		String expectedAlertMsg = "I am a JS Alert";
		String actualAlertText = alert.getText();
		alert.accept();
		System.out.println("Actual alert text: "+ actualAlertText);
		Assert.assertEquals(actualAlertText, expectedAlertMsg);
	}
	
	public void verifyJSConfirm() {
		click(locators.JSConfirm);
		Alert alert = driver.switchTo().alert();
		String expectedAlertMsg = "I am a JS Confirm";
		String actualAlertText = alert.getText();
		alert.accept();
		System.out.println("Actual alert text: "+ actualAlertText);
		Assert.assertEquals(actualAlertText, expectedAlertMsg);	
		
	}
	
	
	public void verifyJSPrompt() {
		click(locators.JSPrompt);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello World!");
		alert.accept();
		String actualAlertText = locators.JSPromptMessage.getText();
		String trim = actualAlertText.substring(13,actualAlertText.length());
		
		System.out.println("Actual alert text: "+trim);
		Assert.assertTrue(trim.equalsIgnoreCase("Hello World!"));
		
	}
	
	
	
	

}
