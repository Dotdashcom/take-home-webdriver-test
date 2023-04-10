package navpreet.Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.IFramePageObjects;
import navpreet.util.ObjectsOfClasses;


public class IFrameTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	IFramePageObjects ifpo;
	String text="Hi!, I'm a Frame";
	
	
	@Test(description="Test switches to Iframe and types some text.Test asserts that the typed text is as expected.")
	public void switchAndCheckText() throws IOException {
		ifpo=iFrameApplication();
		ifpo.ClickFrames();
		ifpo.ClickIFrames();
		ifpo.SwitchAndTypeText(text);
		String textFromFrame = ifpo.verifyText();
		Assert.assertEquals(textFromFrame, text);
	
}

}