package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class ContextMenuTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/context_menu ");
	}
	// Right-click in the box to see one called 'the-internet'. Test JavaScript
	// alert text on Right-Click.
	// Test right clicks on the context menu.
	// Test asserts the alert menu text.

	@Test
	public void verifyContextMenu() {

		WebElement ContextMenu = driver.findElement(By.id("hot-spot"));
		DriverUtility.moveToElementAction(ContextMenu);
		Alert alert = driver.switchTo().alert();

		String expectedMSG = "You selected a context menu";
		String actualMSG = alert.getText();

		Assert.assertTrue(actualMSG.equals(expectedMSG), "Context Menu is selected!");

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}

}
