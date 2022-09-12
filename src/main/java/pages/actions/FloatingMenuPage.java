package pages.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import base.Page;

public class FloatingMenuPage extends Page {
	
	public void verifyScrolling() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Assert.assertTrue(locators.floatingMenu.isDisplayed(), "floating menu is not available");
	}

}
