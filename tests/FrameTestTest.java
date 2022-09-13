package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.FramePage;

public class FrameTestTest extends TestBase{
	FramePage fp=new FramePage();
	
	@BeforeClass
	public void openBrowser() {
		fp.Initialization();
		fp.landingPage();//Navigate to landingPage
	}
	@Test
	public void SwitchToFrame() {
		fp.switchToFrame();//driver switch to frame
	}

	@Test(dependsOnMethods="SwitchToFrame")
	public void VerifyText() {
		Assert.assertTrue(fp.typeAndVerifyText().equals("HappyWorld"));//Write and verify text written
	}
	@AfterClass
	public void afterClass() {
		fp.closeBrowser();//Close the Browser
	}

}
