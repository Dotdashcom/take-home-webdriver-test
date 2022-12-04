package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {

	@Test
	public void dragAndDrop() {

		driver.get("http://localhost:7080/drag_and_drop");
		
		WebElement firstPoint = driver.findElement(By.id("column-a"));
		WebElement secPoint = driver.findElement(By.id("column-b"));
		
		new Actions(driver).dragAndDrop(firstPoint, secPoint).perform();
		
		WebElement textfirstPoint = driver.findElement(By.cssSelector("#column-a header"));
		WebElement textsecPoint = driver.findElement(By.cssSelector("#column-b header"));
		
		Assert.assertEquals(textfirstPoint.getText().trim(), "B");
		Assert.assertEquals(textsecPoint.getText().trim(), "A");
	}
}