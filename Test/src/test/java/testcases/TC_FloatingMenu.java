package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.FloatingMenu;

public class TC_FloatingMenu extends BaseClass {

	@Test	
	public void VerifyFloatingMenu() {

		driver.get("http://localhost:7080/floating_menu");
		FloatingMenu FM = new FloatingMenu(driver);
		FM.scrollDownAndAssertMenuIsDisplayed();
	}
}
