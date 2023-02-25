package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.IframePage;

public class Tc013_iframeTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/iframe");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
	
	@Test
	public void iframeTest() throws IOException {
		IframePage ifp = new IframePage(driver);
		String TextEntered = ifp.HandlingIFrame();
		Assert.assertEquals(TextEntered, "hi! entered into iframe.", " Text entered did not match.");
		logger.info("Text entered matches.");
		bu.captureSrceenshot(driver, "iframeTest");
	}

}
