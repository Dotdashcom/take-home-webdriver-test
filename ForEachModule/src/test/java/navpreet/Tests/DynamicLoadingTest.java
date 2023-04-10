package navpreet.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.DynamicLoadingPageObjects;
import navpreet.util.ObjectsOfClasses;

public class DynamicLoadingTest extends ObjectsOfClasses{

	WebDriver driver;
	DynamicLoadingPageObjects dlpo;
	ObjectsOfClasses base_instance;
	String text;
	
	
	@Test(description="Test clicks the start button and uses explicit wait.\r\n"
			+ "Test asserts that “Hello World!” text is displayed.")
	public void Test_Dynamic_Loading() throws IOException
	{
		dlpo=dynamicLoadingApplication();
		dlpo.ClickDynamicLoading();
		dlpo.ClickExample();
		dlpo.ClickStart();
		dlpo.ExplicitWaitForMessage();
		String text=dlpo.GetMessage();
		Assert.assertEquals(text,"Hello World!");
	}
}
