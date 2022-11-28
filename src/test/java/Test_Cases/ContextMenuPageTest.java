package Test_Cases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.ContextMenuPage;
import TestBase.BaseTest;


public class ContextMenuPageTest extends BaseTest {
	ContextMenuPage contextMenu;

	public ContextMenuPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		contextMenu = new ContextMenuPage();
	}

	@Test
	public void clickContextMenu() {
		//Log.info("Trying to logging into the application.");
		// logging into application
		contextMenu.getUrl();
		String expectedTitle = contextMenu.getTitle();
		String actualTitle = "The Internet";
		//verifying the title of the page
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
		contextMenu.rightClickContextMenu();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "You selected a context menu";
		// verifying the alert text 
		Assert.assertTrue(actualAlertText.equalsIgnoreCase(expectedAlertText));
		// Accepting the alert
		alert.accept();
		//switching to default content
		driver.switchTo().defaultContent();

	}

}
