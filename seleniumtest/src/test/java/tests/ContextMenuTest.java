package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.ContextMenuPage;

public class ContextMenuTest extends GenericPage {

	ContextMenuPage contextMenuPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/context_menu");
		contextMenuPage = new ContextMenuPage();
	}

	@Test
	public void tcContextMenu() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.contextClick(contextMenuPage.contextMenu).perform();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
	}

}