package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import PageObjects.FloatingMenuPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class FloatingMenuTest extends InternetWebBaseTest{
	@Test
	public void testFloatingMenu() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"floating_menu");
		FloatingMenuPage FLMenu=new FloatingMenuPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Assert.assertTrue(FLMenu.floatingmenu().isDisplayed());
	}
}
