package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class DragDropTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
	}

	// Test drags element A to element B.
	// Test asserts that the text on element A and B are switched.
	//Drag and Drop
	@Test

	public void DragAndDrop() {

		Actions action = new Actions(driver);

		WebElement sourceElement = driver.findElement(By.id("column-a"));
		WebElement targetElement = driver.findElement(By.id("column-a"));
		action.dragAndDrop(sourceElement, targetElement);

		Assert.assertTrue(sourceElement.getText().equals("B"));
	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}

}
