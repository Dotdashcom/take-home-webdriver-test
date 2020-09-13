package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.MouseHoverPage;

public class MouseHoverPageTest extends TestBase{
	
	MouseHoverPage mouseHoverPage;
	
	
	@BeforeMethod
	public void setup(){
		initialization("/hovers");
		mouseHoverPage = new MouseHoverPage();
	}
	
	@Test(priority = 1)
	public void mouseHoverTest() {
		
		boolean b = mouseHoverPage.mouseHover();
		Assert.assertTrue(b, "Test case is not passed");
	}

}
