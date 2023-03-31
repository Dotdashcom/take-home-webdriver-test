package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.IFramesPage;


public class IFramesTest extends BaseTest{
	IFramesPage iFrames;
	
	@Before
	public void setup() throws IOException {

		setup("/iframe");
		iFrames = new IFramesPage(driver);
	}
	
	@Test
	public void switchAndCheckText() {
		String expectedText="This is iFrame";
		iFrames.switchAndTypeText(expectedText);
		String frameText=iFrames.verifyText();
		Assert.assertEquals(frameText, expectedText);
	}
	
}
