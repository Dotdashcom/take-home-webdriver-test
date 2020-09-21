package tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class DropDownTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/dropdown");
	}

	// Test selects Option 1 and Option 2 from the drop down menu.
	// Test asserts Option 1 and Option 2 are selected.

	@Test
	public void StaticDropdown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.id("dropdown"));

		DriverUtility.SelectByIndex(dropdown, 1);
		String option1 = dropdown.getText();
		DriverUtility.wait(2000);
		DriverUtility.SelectByIndex(dropdown, 2);
		String option2 = dropdown.getText();

		Assert.assertEquals(option1, "Option 1");
		Assert.assertEquals(option2, "Option 2");

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}