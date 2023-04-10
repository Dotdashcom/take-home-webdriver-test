package navpreet.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import navpreet.pageobjects.MouseHoverPageObjects;
import navpreet.util.ObjectsOfClasses;


public class MouseHoverTest extends ObjectsOfClasses {

	ObjectsOfClasses base_instance;
	MouseHoverPageObjects mhpo;
	String text;
	
	
	@Test(description="Test does a mouse hover on each image.Test asserts that additional information is displayed for each image.")
	public void TestMouseHoverFunctionality() throws IOException
	{
		
		mhpo=mouseHoverApplication();
		mhpo.ClickHovers();
		mhpo.mouseHover();
	}
}
