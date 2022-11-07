package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.IFramePage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class IFrameTest extends InternetWebBaseTest{
	@Test
	public void testIFrame() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"iframe");
		driver.switchTo().frame("mce_0_ifr");
		IFramePage frame=new IFramePage(driver);
		frame.searchiframe();
		Assert.assertEquals("Test data is not retriving from frame",frame.getTextFromiframe(),"Frame inside");
	}

}
