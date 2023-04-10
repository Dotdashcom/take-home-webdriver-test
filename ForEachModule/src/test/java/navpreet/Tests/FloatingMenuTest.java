package navpreet.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.FloatingMenuPageObjects;
import navpreet.util.ObjectsOfClasses;

public class FloatingMenuTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	FloatingMenuPageObjects fmpo;
	
	
	@Test(description="Test scrolls the page.Test asserts that the floating menu is still displayed.")
	public void TestFloatingMenu() throws IOException
	{
		fmpo=floatingMenuApplication();
		fmpo.ClickFloatingMenu();
		boolean beforeScroll=fmpo.CheckFloatingMenu();
		Assert.assertEquals(beforeScroll, true);
		fmpo.ScrollMenu();
		boolean afterScroll=fmpo.CheckFloatingMenu();
		Assert.assertTrue(afterScroll);
	}
}
