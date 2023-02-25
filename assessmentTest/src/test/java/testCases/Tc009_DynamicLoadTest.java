package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.DynamicLoadPage;

public class Tc009_DynamicLoadTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/dynamic_loading/2");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void DynamicLoadTest() throws IOException {
		DynamicLoadPage dlp = new DynamicLoadPage(driver);
		String msgDisplayed = dlp.dynamicLoad();
		Assert.assertEquals(msgDisplayed, "Hello World!");
		logger.info("Messages matches");
		bu.captureSrceenshot(driver, "DynamicLoadTest");
	}

}
