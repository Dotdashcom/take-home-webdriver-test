package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class OpenNewWindowTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/windows");
	}

	// Test clicks on the Click Here link.
	// Test asserts that a new tab is opened with text New Window.
	@Test
	public void OpenNewWindow() {

		WebElement clickHere = driver.findElement(By.cssSelector("#content > div > a"));
		DriverUtility.clickonElement(clickHere);

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		String pageTitle = driver.getTitle();
		System.out.println("After switching to window: " + pageTitle);

		Assert.assertEquals(pageTitle, "New Window");
	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}

}
