package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class DragAndDrop extends TestBase {
	
	@BeforeTest
	public void BeforeDragandDropTest() {
		setup();
		driver.get("http://localhost:7080/drag_and_drop");
	}
	
	@AfterTest
	public void afterDragAndDropTest() {
		teardown();
	}
	
	@Test //Test for some reason fails because the dragAndDrop function does not work even though I put the correct location for the source and destination
	public void DragAndDropTest()  {
		//driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
		WebElement elementA = driver.findElement(By.id("column-a"));
		WebElement elementB = driver.findElement(By.id("column-b"));
		Actions action = new Actions(driver);
		action.dragAndDrop(elementA, elementB); //Drag and Drop not working automatically only manually
		Assert.assertEquals(elementA.getText(), "B");
	}

}
