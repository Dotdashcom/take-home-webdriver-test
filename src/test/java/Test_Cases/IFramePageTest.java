package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.IFramePage;
import TestBase.BaseTest;

public class IFramePageTest extends BaseTest {
	IFramePage iFrame;

	public IFramePageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		iFrame = new IFramePage();
	}

	@Test
	public void mouseHoverImage1() {

		// logging into application
		iFrame.getUrl();

		// switch to the frame
		String actualText = iFrame.switchToFrame();
		String expectedText = "testSample";
		Assert.assertEquals(actualText, expectedText);

		// iFrame.clickCreateAccountLink();
	}

}