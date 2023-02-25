package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.baseutils;
import pageObjects.DynamicContentPage;

public class Tc007_DynamicContentTest extends baseutils{
	baseutils bu =  new baseutils();
	public static DynamicContentPage dcp; 
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/dynamic_content");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void DynamicContentTest1() throws IOException, InterruptedException {
		dcp = new DynamicContentPage(driver);
		System.out.println("-----------content 1--------------");
		boolean Result = dcp.DynamicContent1();
		Assert.assertFalse(Result, "Content matches before and after refresh");
		logger.info("Content didn't match before and after refresh");
		bu.captureSrceenshot(driver, "DynamicContentTest1");
	
		System.out.println("-----------content 2--------------");
		Thread.sleep(2000);
		boolean Result1 = dcp.DynamicContent2();
		Assert.assertFalse(Result1, "Content matches before and after refresh");
		logger.info("Content didn't match before and after refresh");
		bu.captureSrceenshot(driver, "DynamicContentTest2");
	
		System.out.println("-----------content 3--------------");
		Thread.sleep(2000);
		boolean Result2 = dcp.DynamicContent3();
		Assert.assertFalse(Result2,"Content matches before and after refresh");
		logger.info("Content didn't match before and after refresh");
		bu.captureSrceenshot(driver, "DynamicContentTest3");
	}


}
