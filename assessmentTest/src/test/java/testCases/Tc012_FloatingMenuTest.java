package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.FloatingMenuPage;

public class Tc012_FloatingMenuTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/floating_menu");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void FloatingMenuTest() throws AWTException, IOException {
		FloatingMenuPage fmp = new FloatingMenuPage(driver);
		boolean MenuStatus = fmp.HandlingFloatingMenu();
		Assert.assertTrue(MenuStatus, "Floating menu not displayed");
		logger.info("Assertion Pass");
		bu.captureSrceenshot(driver, "FloatingMenuTest");
	}

}
