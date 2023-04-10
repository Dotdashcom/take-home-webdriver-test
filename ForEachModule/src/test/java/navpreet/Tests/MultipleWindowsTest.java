package navpreet.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.MultipleWindowsPageObjects;
import navpreet.util.ObjectsOfClasses;

public class MultipleWindowsTest extends ObjectsOfClasses {

	ObjectsOfClasses base_instance;
	MultipleWindowsPageObjects mwpo;
	String new_tab_title, title;
	
	@Test(description="Test clicks on the Click Here link.Test asserts that a new tab is opened with text New Window.")
	public void TestMultipleWindows() throws IOException
	{
		mwpo=multipleWindowsApplication();
		mwpo.ClickWindows();
		mwpo.Click_ClickHere();
		new_tab_title=mwpo.openAndSwitchToNewWindow();
	    title=mwpo.Check_NewTabTitle();
		Assert.assertEquals(new_tab_title, title);
	}
}
