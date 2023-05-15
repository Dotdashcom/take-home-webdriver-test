package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pageObjectModel.DragAndDropPage;
import pageObjectModel.HomePage;


public class DragAndDropTest extends BaseTest{
	@Test
	public void dragAndDrop() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		DragAndDropPage dragDrop = homePage.clickDragAndDrop();
		boolean result = dragDrop.dragAndDrop();
		assertTrue(result);
	}
}
