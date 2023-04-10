package navpreet.Tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.ContextMenuPageObject;
import navpreet.util.ObjectsOfClasses;



public class ContextMenuTest extends ObjectsOfClasses {

	ObjectsOfClasses base_instance;
	WebDriver driver;
	ContextMenuPageObject cmpo;
	String message="You selected a context menu";
	
	
	
	@Test(description="Test right clicks on the context menu.Test asserts the alert menu text.")
	public void ContextMenu() throws IOException
	{
		cmpo=contextMenuApplication();
		cmpo.ClickContextMenu();
		cmpo.Right_Click();
		String alert_message=cmpo.AcceptingAndGrabbingTextOfAlert();
		Assert.assertEquals(message, alert_message);
	}
}
