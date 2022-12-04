package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest extends TestBase {

	@Test
	public void checkBoxes() {

		driver.get("http://localhost:7080/checkboxes");
		WebElement cbx1 = driver.findElement(By.cssSelector("form input:nth-of-type(1)"));
		WebElement cbx2 = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
		cbx1.click();
		Assert.assertTrue(cbx1.isSelected());
		cbx2.click();
		Assert.assertTrue(!cbx2.isSelected());
	}
}