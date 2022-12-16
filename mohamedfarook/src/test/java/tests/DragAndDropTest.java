package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseClass {

	DragAndDropPage dragDropObj;

	public DragAndDropTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/drag_and_drop");
		dragDropObj = new DragAndDropPage();
	}

	@Test
	public void dragDrop() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragDropObj.FirstColumn).moveToElement(dragDropObj.SecondColumn).release().build()
				.perform();
		Thread.sleep(4000);
		System.out.println(dragDropObj.FirstColumn.getText());
		Thread.sleep(4000);
		Assert.assertEquals(dragDropObj.SecondColumn.getText(), "B");
		Assert.assertEquals(dragDropObj.FirstColumn.getText(), "A");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
