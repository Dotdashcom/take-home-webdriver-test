package pages.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import base.Constants;
import base.Page;
import pages.locators.AllLocators;

public class ContextMenuPage extends Page {
	
	public void rightClickOnContextMenu() {
		Actions actions = new Actions(driver);
		actions.contextClick(locators.contextMenu).perform();
	}
	
	public void verifyAlertMenuText() {
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = Constants.javascriptAlertText;
		System.out.println("Alert Text: "+ actualAlertText);
		Assert.assertEquals(actualAlertText, expectedAlertText , "alert texts are not matching");
		System.out.println("Alert text is captured - Assert Passed");
		alert.accept();
		
	}
	

}
