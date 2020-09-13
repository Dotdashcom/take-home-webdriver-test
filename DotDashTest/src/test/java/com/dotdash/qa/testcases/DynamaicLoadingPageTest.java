package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DynamicLoadingPage;

public class DynamaicLoadingPageTest extends TestBase{
	
	DynamicLoadingPage dynamaicLoadingPage;
	
	
	
	@BeforeMethod
	public void setup(){
		initialization("/dynamic_loading/2");
		dynamaicLoadingPage = new DynamicLoadingPage();
	}
	
	@Test(priority = 1)
	public void dynamicCheckBoxTest() {
		
		boolean b1 = dynamaicLoadingPage.displayTextTest();
		Assert.assertTrue(b1, "Dynamic check box Test case is passed");
		
	}

}
