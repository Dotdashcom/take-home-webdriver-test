package pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Page;

public class MouseHoverPage extends Page {
	
	public void verifyMouseHover() {
		Actions action = new Actions(driver);
		action.moveToElement(locators.mouseHover1).build().perform();
		Assert.assertTrue(locators.mouseHoverCaption.isEnabled(), "additional info not enabled");
		
		action.moveToElement(locators.mouseHover2).build().perform();
		Assert.assertTrue(locators.mouseHoverCaption.isEnabled(), "additional info not enabled");
		
		action.moveToElement(locators.mouseHover3).build().perform();
		Assert.assertTrue(locators.mouseHoverCaption.isEnabled(), "additional info not enabled");
		
		
	}
	

}
