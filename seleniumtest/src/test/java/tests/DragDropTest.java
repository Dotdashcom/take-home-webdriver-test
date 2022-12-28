package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DragDropPage;

public class DragDropTest extends GenericPage {

	DragDropPage dragDropPage;
	
	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/drag_and_drop");
		dragDropPage = new DragDropPage();
	}

	@Test
	public void tcDragDrop() throws InterruptedException {
		dragDropPage.dragDrop();
        Thread.sleep(2000);
	}
}