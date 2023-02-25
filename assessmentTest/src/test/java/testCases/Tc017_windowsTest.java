package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.WindowsPage;

public class Tc017_windowsTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/windows");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void windowsTest() throws IOException {
		WindowsPage wp = new WindowsPage(driver);
		String textDisplayed = wp.HandlingNewWindow();
		Assert.assertEquals(textDisplayed, "New Window");
		logger.info("text matches");
		bu.captureSrceenshot(driver, "windowsTest");
	}

}
