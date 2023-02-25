package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.MouseHoverPage;

public class Tc014_MouseHoverTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/hovers");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void MouseHoverTest() throws IOException {
		MouseHoverPage mhp = new MouseHoverPage(driver);
		System.out.println("------First Image-----------");
		boolean Image1CaptionStatus1 = mhp.HandlingImage1();
		Assert.assertTrue(Image1CaptionStatus1, "Caption is not displyed");
		logger.info("Assertion Pass");
		
		System.out.println("------Second Image-----------");
		boolean Image1CaptionStatus2 = mhp.HandlingImage2();
		Assert.assertTrue(Image1CaptionStatus2, "Caption is not displyed");
		logger.info("Assertion Pass");
		
		System.out.println("------Third Image-----------");
		boolean Image1CaptionStatus3 = mhp.HandlingImage3();
		Assert.assertTrue(Image1CaptionStatus3, "Caption is not displyed");
		logger.info("Assertion Pass");
		bu.captureSrceenshot(driver, "MouseHoverTest");
	}

}
