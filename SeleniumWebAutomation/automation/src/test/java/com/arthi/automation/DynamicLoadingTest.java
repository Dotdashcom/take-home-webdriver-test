package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.DynamicLoadingPage;

public class DynamicLoadingTest extends TestBase {
	
	@Test
	public void TestDynomicLoadingEvent() throws InterruptedException{
		DynamicLoadingPage dynamicloadingPage =new DynamicLoadingPage(getDriver());
		dynamicloadingPage.navigateToDynamicLoadingPage()
		.verifyPageLoadingEvent();
	}

}
