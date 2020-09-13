package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DynamicContentPage;

public class DynamicContentPageTest extends TestBase {

	DynamicContentPage dynamicContentPage;

	@BeforeMethod
	public void setup() {
		initialization("/dynamic_content");
		dynamicContentPage = new DynamicContentPage();
	}

	@Test(priority = 1)
	public void dynamicContentTest(){
		boolean b = dynamicContentPage.verifyContent();
		Assert.assertTrue(b, "Test case is passed");
	}
}