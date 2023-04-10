package navpreet.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import navpreet.pageobjects.DynamicContentPageObject;
import navpreet.util.ObjectsOfClasses;


public class DynamicContentTest extends ObjectsOfClasses {

	WebDriver driver;
	DynamicContentPageObject dcpo;
	ObjectsOfClasses base_instance;
	
	
	@Test(description="Test refreshes the page a couple of times.Test asserts that the content changes on each refresh.")
	public void LoadDynamicContent() throws IOException
	{
		dcpo=dynamicContentApplication();
		dcpo.ClickDynamicContent();
		dcpo.RefreshPage(5);
	}
}
