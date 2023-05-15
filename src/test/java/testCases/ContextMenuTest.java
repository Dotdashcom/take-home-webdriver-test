package testCases;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjectModel.ContextMenuPage;
import pageObjectModel.HomePage;

public class ContextMenuTest extends BaseTest{
	@Test
	public void contextClick() {
		HomePage homepage = new HomePage(driver);
		ContextMenuPage contextMenuPage = homepage.clickContextMenu();
		contextMenuPage.contextClick();
		assertTrue(contextMenuPage.alertText().contains("You selected a context menu"));		
	}
}
